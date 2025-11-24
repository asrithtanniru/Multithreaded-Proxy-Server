package client;

import java.io.*;
import java.net.*;

public class ProxyClient {
    public static void main(String[] args) {
        try {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter URL: ");
            String url = userInput.readLine();

            Socket socket = new Socket("localhost", 8080);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            // Send URL to proxy server
            out.println(url);

            // Read returned HTML
            StringBuilder html = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                html.append(line).append("\n");
            }

            // Save HTML locally
            FileSaver.save(url, html.toString());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
