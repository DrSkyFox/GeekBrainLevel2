package lessonsix.client;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private DataInputStream inSD;
    private DataOutputStream outSD;
    private JTextArea charArea;
    private Scanner scanner;

    public Client() {
        this(null);
    }

    public Client(JTextArea charArea) {
        this.charArea = charArea;

        try {
            Socket socket = new Socket("127.0.0.1", 18443);
            System.out.println("Client info: " + socket);

            inSD = new DataInputStream(socket.getInputStream());
            outSD = new DataOutputStream(socket.getOutputStream());


            if (charArea == null) {
                scanner = new Scanner(System.in);
            }

            Thread inStreamDataThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println("Считываю входящий");
                            String message = inSD.readUTF();
                            if (charArea != null) {
                                charArea.append(message);
                            } else {
                                System.out.println(message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            if (charArea == null) {
                Thread outStreamDataThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                System.out.println("Напишите сообщение: ");
                                String message = scanner.nextLine();
                                outSD.writeUTF(message);
                                if (charArea != null) {
                                    charArea.append(message);
                                } else {
                                    System.out.println(message);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                outStreamDataThread.start();
                try {
                    outStreamDataThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            inStreamDataThread.start();

            inStreamDataThread.join();

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                inSD.close();
                outSD.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public DataInputStream getIn() {
        return inSD;
    }

    public DataOutputStream getOut() {
        return outSD;
    }

    public static void main(String[] args) {
        new Client();
    }
}
