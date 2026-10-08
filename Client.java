import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        Scanner sc = new Scanner(System.in);

        DataInputStream dis =
            new DataInputStream(s.getInputStream());

        DataOutputStream dos =
            new DataOutputStream(s.getOutputStream());

        while (true) {

            // Client receives message
            String msg = dis.readUTF();

            System.out.println("Server: " + msg);

            if (msg.equalsIgnoreCase("bye")) {
                break;
            }

            // Client sends message
            System.out.print("Client: ");
            String reply = sc.nextLine();

            dos.writeUTF(reply);
            dos.flush();

            if (reply.equalsIgnoreCase("bye")) {
                break;
            }
        }

        s.close();
        sc.close();
    }
}