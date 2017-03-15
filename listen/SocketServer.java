import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {

    public SocketServer(int port) {
        try (ServerSocket server = new ServerSocket(port);
                Socket sk = server.accept();
                BufferedReader rdr = new BufferedReader(
                        new InputStreamReader(sk.getInputStream()));) {

            String line = rdr.readLine();
            System.out.println("receive:" + line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java  SocketServer port");
        }

        int port = Integer.parseInt(args[0]);
        new SocketServer(port);
    }
}