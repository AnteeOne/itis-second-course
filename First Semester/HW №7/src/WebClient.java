import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class WebClient {

    private static Socket clientSocket;
    private static BufferedReader reader;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {

        String hostname = "www.anteeone.tech";
        Integer port = 80;

        try {


           Socket socket = new Socket(InetAddress.getByName(hostname),port);
           System.out.println("Client has connected to the server");


           try {
               BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
               wr.write("GET / HTTP/1.1");
               wr.write("Host: " + hostname);
               wr.flush();

               BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               String line;

               while ((line = rd.readLine()) != null) {
                   System.out.println(line);
               }

               wr.close();
               rd.close();

           }
           catch (Exception e){
               e.printStackTrace();
           }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
