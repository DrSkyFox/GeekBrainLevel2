package lessonseven.client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienAppTwo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("-auth l1 p2");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String message = in.readUTF();
                            System.out.println(message);
                            Thread.sleep(5000);
                            if (message.contains("Incorrect credentials")) {
                                out.writeUTF("-auth l2 p2");
                            }
                            Thread.sleep(5000);
                            out.writeUTF("/w u1 hello");
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }).start();

            out.writeUTF("-exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
