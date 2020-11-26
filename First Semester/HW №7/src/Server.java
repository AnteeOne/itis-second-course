import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);

                System.out.println("Server has opened");

                clientSocket = server.accept();

                JFrame frame = new JFrame("Sockets example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.setBounds(300, 200, 700, 900);
                frame.setVisible(true);

                try {

                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String line;
                    while(!(line = in.readLine()).equals("exit")){
                        Color color = new Color(Integer.valueOf(line));
                        panel.setBackground(color);

                        System.out.println(line);

                        out.write("[server] client has wrote: " + line + "\n");
                        out.flush();
                    }



                } finally {

                    clientSocket.close();

                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server has closed");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}