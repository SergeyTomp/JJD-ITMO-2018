package hw10.OnlineDecorator;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
import hw10.EncryptionDecorator.CryptedOutputStream;

public class Client {

    private SocketAddress socketAddress;
    private Scanner scanner;
    private String password;

    public Client(SocketAddress address, Scanner scanner, String key){
        this.socketAddress = address;
        this.scanner = scanner;
        password = key;
    }

    public static void main(String[] args) throws IOException {
        String addr = null;

        if (args != null && args.length > 0) {
            addr = args[0];
        }

        Scanner scanner = new Scanner(System.in);

        if (addr == null) {
            System.out.println("Enter server address");
            addr = scanner.nextLine();
        }
//        "212.21.21.21:9085"
        Client simpleClient = new Client(parseAddr(addr), scanner, "qwerty");
        simpleClient.start();
    }

    private void start() throws IOException {
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        while (true){
            System.out.println("Enter your message");
            String msg = scanner.nextLine();
            buildAndSendMess(name, msg);
        }
    }

    private void buildAndSendMess(String name, String msg) throws IOException {
        Message message = new Message(name, msg);
        sendMess(message);
    }

    private void sendMess(Message message) throws IOException {
        try (Socket socket = new Socket()){
            socket.connect(socketAddress);
            try (OutputStream out = new CryptedOutputStream(socket.getOutputStream(), password)){
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                objOut.writeObject(message);
                objOut.flush();
            }
        }
    }

    private static SocketAddress parseAddr(String addr){
        String[] str = addr.split(":");
        return new  InetSocketAddress(str[0], Integer.parseInt(str[1]));
    }
}