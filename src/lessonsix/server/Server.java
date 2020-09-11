package lessonsix.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private DataInputStream inSD;
    private DataOutputStream outSD;
    private Scanner scanner ;
    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(18443);

            System.out.println("Server waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);

            inSD = new DataInputStream(socket.getInputStream());
            outSD = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            Thread inStreamThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = inSD.readUTF();
                            System.out.println("Incoming message: " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread outStreamThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Введите сообщение");
                    while (true) {
                        try {
                            String message = scanner.nextLine();
                            outSD.writeUTF(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            inStreamThread.start();
            outStreamThread.start();

            inStreamThread.join();
            outStreamThread.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                inSD.close();
                outSD.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}