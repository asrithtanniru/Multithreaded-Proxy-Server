package server;

import java.net.*;

public class ProxyServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            ClientHandlerFactory factory = new ClientHandlerFactory();

            System.out.println("Proxy server running on port 8080...");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected.");

                // Create handler using factory (DESIGN PATTERN)
                ClientHandler handler = factory.createHandler(client);
                handler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
