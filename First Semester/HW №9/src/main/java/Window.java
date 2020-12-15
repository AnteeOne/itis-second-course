import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    private JFrame frame;
    private JMenu menu;
    private JPanel panel;
    private JMenuBar menuPanel;
    private JCheckBoxMenuItem checkboxMenuItem;
    private JRadioButtonMenuItem radioButtonMenuItem;
    private JMenuItem menuItem;

    public static void main(String[] args) {
        Window window = new Window();
        window.onCreate();
        window.onVisible();

    }

    private void onCreate() {
        initGUI();
    }

    private void initGUI() {
        initFramePanel();
        initMenuPanel();
        initContentPanel();
        initRightPanel();



    }

    private void initFramePanel(){
        frame = new JFrame("Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initMenuPanel() {
        menuPanel = new JMenuBar();
        menu = new JMenu("Menu");
        JMenu menu2 = new JMenu("Second");
        JMenu menu3 = new JMenu("Meme");
        JMenu menu4 = new JMenu("kek");
        menuPanel.add(menu);
        menuPanel.add(menu2);
        menuPanel.add(menu3);
        menuPanel.add(menu4);
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
        panel.setBackground(Color.cyan);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void initRightPanel() {
        JPanel rightPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(10, 0, 200, 10);
        rightPanel.setLayout(gridLayout);
        JButton drawButton1 = new JButton("Дети Rave");
        JButton drawButton2 = new JButton("Дети Rave");
        JButton drawButton3 = new JButton("Дети Rave");
        JButton drawButton4 = new JButton("Дети Rave");
        JButton drawButton5 = new JButton("Новый мерин");
        JButton drawButton6 = new JButton("Новый мерин");
        JButton drawButton7 = new JButton("Новый мерин");
        JButton drawButton8 = new JButton("Новый мерин");
        rightPanel.add(drawButton1);
        rightPanel.add(drawButton2);
        rightPanel.add(drawButton3);
        rightPanel.add(drawButton4);
        rightPanel.add(drawButton5);
        rightPanel.add(drawButton6);
        rightPanel.add(drawButton7);
        rightPanel.add(drawButton8);
        rightPanel.setBackground(Color.pink);
        Dimension dim = new Dimension(300, 300);
        rightPanel.setPreferredSize(dim);
        frame.getContentPane().add(rightPanel, BorderLayout.EAST);
    }

    private void onVisible() {
        frame.setBounds(10, 10, 1900, 1000);
        frame.setVisible(true);
    }

    private class OnExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
