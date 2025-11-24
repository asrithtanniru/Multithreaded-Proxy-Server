package server;

import java.io.*;
import java.net.*;
import server.utils.HttpFetcher;

public class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read URL from client
            String url = in.readLine();
            System.out.println("Fetching: " + url);

            // Fetch HTML from real server
            String html = HttpFetcher.fetch(url);

            // Send HTML back
            out.println(html);
            out.flush();

            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
