import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Waiting for client...");

        Socket s = ss.accept();

        System.out.println("Client connected");

        Scanner sc = new Scanner(System.in);

        DataInputStream dis =
            new DataInputStream(s.getInputStream());

        DataOutputStream dos =
            new DataOutputStream(s.getOutputStream());

        while (true) {

            // Server sends message
            System.out.print("Server: ");
            String msg = sc.nextLine();

            dos.writeUTF(msg);
            dos.flush();

            if (msg.equalsIgnoreCase("bye")) {
                break;
            }

            // Server receives message
            String reply = dis.readUTF();

            System.out.println("Client: " + reply);

            if (reply.equalsIgnoreCase("bye")) {
                break;
            }
        }

        s.close();
        ss.close();
        sc.close();
    }
}