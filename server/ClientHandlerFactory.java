package server;

import java.net.Socket;

public class ClientHandlerFactory {
    public ClientHandler createHandler(Socket clientSocket) {
        return new ClientHandler(clientSocket);
    }
}
