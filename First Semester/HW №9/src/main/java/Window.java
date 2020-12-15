import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

/*
    Completed:
       - Status Bar
       - Rectangle
       - Rectangle animation
       - Form
       - Form Listeners for closing form
       - MenuBar
 */

public class Window {

    private JFrame frame;
    private JMenu menu;
    private JPanel panel;
    private JMenuBar menuPanel;
    private JCheckBoxMenuItem checkboxMenuItem;
    private JRadioButtonMenuItem radioButtonMenuItem;
    private JMenuItem menuItem;
    private JLabel statusText;

    private boolean shapeIsNotAnimating = true;
    private Graphics2D graphics2D;
    private Shape shape;

    private JButton drawButton1;
    private JButton drawButton2;
    private JButton drawButton3;

    public static void main(String[] args) {
        Window window = new Window();
        window.onCreate();

    }

    private void onCreate() {
        initGUI();
    }

    private void initGUI() {
        initFramePanel();
        onVisible();
        initMenuPanel();
        initContentPanel();
        initRightPanel();
        initStatusPanel();

    }

    private void initFramePanel() {
        frame = new JFrame("Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        graphics2D = (Graphics2D) frame.getGraphics();
    }

    private void initMenuPanel() {
        menuPanel = new JMenuBar();
        menu = new JMenu("Menu");
        JMenu menu2 = new JMenu("About");
        menu2.addMenuListener(new onAboutListener());
        menuPanel.add(menu);
        menuPanel.add(menu2);
        menu.addSeparator();
        menuItem = new JMenuItem("Choose your gender");
        menu.add(menuItem);

        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        radioButtonMenuItem = new JRadioButtonMenuItem("Human");
        radioButtonMenuItem.setSelected(true);
        group.add(radioButtonMenuItem);
        menu.add(radioButtonMenuItem);
        radioButtonMenuItem = new JRadioButtonMenuItem("Female");
        group.add(radioButtonMenuItem);
        menu.add(radioButtonMenuItem);
        menu.addSeparator();
        checkboxMenuItem = new JCheckBoxMenuItem("I am racist");
        menu.add(checkboxMenuItem);
        checkboxMenuItem = new JCheckBoxMenuItem("all lives is matter");
        menu.add(checkboxMenuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new Window.OnExitListener());
        menu.add(menuItem);
        frame.setJMenuBar(menuPanel);

    }

    private void initContentPanel() {
        panel = new JPanel();
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(panel , BorderLayout.CENTER);
    }

    private void initRightPanel() {
        JPanel rightPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(10 , 0 , 200 , 10);
        rightPanel.setLayout(gridLayout);
        drawButton1 = new JButton("Square");
        drawButton2 = new JButton("Rotate");
        drawButton3 = new JButton("Show form");
        drawButton1.addMouseListener(new MouseListener());
        drawButton2.addMouseListener(new MouseListener());
        drawButton3.addMouseListener(new MouseListener());
        drawButton1.addActionListener(new SquareListener());
        drawButton2.addActionListener(new AnimationListener());
        drawButton3.addActionListener(new FormListener());
        rightPanel.add(drawButton1);
        rightPanel.add(drawButton2);
        rightPanel.add(drawButton3);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        Dimension dim = new Dimension(300 , 300);
        rightPanel.setPreferredSize(dim);
        frame.getContentPane().add(rightPanel , BorderLayout.EAST);
    }

    private void initStatusPanel() {
        JPanel bottomPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        bottomPanel.setLayout(flowLayout);
        bottomPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(bottomPanel , BorderLayout.SOUTH);
        bottomPanel.setPreferredSize(new Dimension(frame.getWidth() , 20));
        bottomPanel.setLayout(new BoxLayout(bottomPanel , BoxLayout.X_AXIS));
        statusText = new JLabel("status");
        bottomPanel.add(statusText);
    }

    private void onVisible() {
        frame.setBounds(10 , 10 , 1900 , 1000);
        frame.setVisible(true);
        graphics2D = (Graphics2D) frame.getGraphics();
    }

    private void onClearContentPanel() {
        shapeIsNotAnimating = true;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    private class OnExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    //create blank menu
    private class onAboutListener implements MenuListener {

        private JFrame aboutFrame;

        @Override
        public void menuSelected(MenuEvent e) {
            aboutFrame = new JFrame("About");
            aboutFrame.setBounds(600 , 300 , 500 , 500);
            aboutFrame.setVisible(true);
            aboutFrame.setAlwaysOnTop(true);
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }

    private class MouseListener extends MouseAdapter {
        public void mouseEntered(MouseEvent me) {
            if (me.getSource() == drawButton1) {
                statusText.setText("draw square");
            }
            if (me.getSource() == drawButton2) {
                statusText.setText("rotate square");
            }
            if (me.getSource() == drawButton3) {
                statusText.setText("show form");
            }
        }

        public void mouseExited(MouseEvent me) {
            statusText.setText("status");
        }
    }

    private class SquareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int width = panel.getSize().width;
            int height = panel.getSize().height;
            shape = new Rectangle((width / 2) , (height / 2) , height / 4 , height / 4);
            graphics2D.setColor(Color.BLACK);
            graphics2D.fill(shape);
        }
    }

    private class AnimationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            shapeIsNotAnimating = !shapeIsNotAnimating;
            new Thread(() -> {
                while (true) {
                    if (shapeIsNotAnimating) {
                        break;
                    }
                    panel.repaint();
                    SwingUtilities.invokeLater((Runnable) () -> {
                        graphics2D.rotate(Math.toRadians(15) , panel.getSize().width / 2 , panel.getSize().height / 2);
                        graphics2D.draw(shape);
                        graphics2D.setColor(Color.black);
                        graphics2D.fill(shape);
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException exc) {
                        statusText.setText("Animation Error!");
                    }
                }
            }).start();
        }
    }

    private class FormListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            onClearContentPanel();
            Container container = new Container();
            JButton button = new JButton("Agree with it");
            button.addActionListener(new FormSubmitListener());
            JTextField textField = new JTextField(15);
            textField.setText("Swing - big piece of shit");
            panel.add(textField);
            panel.add(button);
            panel.setVisible(true);
        }
    }

    private class FormSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            onClearContentPanel();
        }
    }

}

