package lessonseven.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Represents client session
 */
public class ClientHandler {
    private String name;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;
    private ExecutorService executorService;
    private static int timeOutSeconds = 120;

    public static int getTimeOutSeconds() {
        return timeOutSeconds;
    }

    public static void setTimeOutSeconds(int timeOutSeconds) {
        ClientHandler.timeOutSeconds = timeOutSeconds;
    }



    public ClientHandler(Socket socket, Server server, ExecutorService executorService) {
        this.socket = socket;
        this.executorService = executorService;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Future<Boolean> future = (Future<Boolean>) executorService.submit(() -> {
//                    try {
//                        authenticate();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
                try {
//                    future.get(timeOutSeconds,TimeUnit.SECONDS);
//                    executorService.shutdown();
                    auth();
                    readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (TimeoutException e) {
//                    System.out.println("Время вышло");
                } catch (AuthTimeOutException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        }).start();
    }

    public Boolean authenticate() throws IOException {
        System.out.println("Client auth is on going...");

        while (true) {
            String loginInfo = in.readUTF();
            if (loginInfo.startsWith("-auth")) {
                // -auth l1 p1
                String[] splitLoginInfo = loginInfo.split("\\s");
                AuthenticationService.Client maybeClient = server.getAuthenticationService()
                        .findByLoginAndPassword(
                                splitLoginInfo[1],
                                splitLoginInfo[2]
                        );
                if (maybeClient != null) {
                    if (!server.checkLogin(maybeClient.getName())) {
                        sendMessage("status: authok");
                        name = maybeClient.getName();
                        server.broadcast(String.format("%s came in", name));
                        System.out.println("Client auth completed");
                        server.subscribe(this);
                        return true;
                    } else {
                        sendMessage(String.format("%s already logged in", maybeClient.getName()));
                    }
                } else {
                    sendMessage("Incorrect credentials");
                }
            }
        }
    }



    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcast(String.format("%s left", name));
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            String formatterMessage = String.format("Message from %s: %s", name, message);
            System.out.println(formatterMessage);
            if (message.equalsIgnoreCase("-exit")) {
                return;
            }
            if(message.startsWith("/w")) {
                System.out.println(true);
                String[] strings = message.split("\\s");
                server.broadcast(this, strings[1], strings[2]);
            } else {
                server.broadcast(formatterMessage);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void auth() throws AuthTimeOutException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    authenticate();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join(timeOutSeconds*1000);
            System.out.println("thread join and status : " + thread.isAlive());
            if(thread.isAlive()) {
                System.out.println("Interrupt");
                thread.interrupt();
                throw new AuthTimeOutException("Time ended", (timeOutSeconds*1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Catch exception");
        }
    }

}
