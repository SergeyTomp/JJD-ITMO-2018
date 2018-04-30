package hw10.OnlineDecorator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import hw10.EncryptionDecorator.CryptedInputStream;

public class Server {
    private int port;
    String password;
    public Server(int port, String key) {
        password = key;
        this.port = port;
    }

    private void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server on: " + serverSocket);
            while (true) {
                Socket sock = serverSocket.accept();
                try {
                    getMess(sock);
                } catch (ClassNotFoundException e) {
                    System.out.println("Wrong mess");
                    e.printStackTrace();
                } finally {
                    sock.close();
                }
            }
        }
    }

    private void getMess(Socket socket) throws IOException, ClassNotFoundException {
        String host = socket.getInetAddress().getHostAddress();
        try (ObjectInputStream objIn = new ObjectInputStream(new CryptedInputStream(socket.getInputStream(), password))) {
//             OutputStream out = socket.getOutputStream()
            Object obj = objIn.readObject();
            printMess((Message) obj, host);
        }

    }

    private void printMess(Message msg, String sendedAddr) {
        System.out.println("message: " + msg.getMessText() +
                        " from " + msg.getSender() +
                        " " + sendedAddr
        );
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("port must be spec");
        }

        int port = Integer.parseInt(args[0]);
        Server simpleServer = new Server(port, "qwerty");
        simpleServer.start();
    }

}
