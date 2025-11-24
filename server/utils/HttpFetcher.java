package server.utils;

import java.io.*;
import java.net.*;

public class HttpFetcher {

    public static String fetch(String urlStr) throws Exception {
        StringBuilder builder = new StringBuilder();

        URL url = new URL(urlStr);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(url.openStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();

        return builder.toString();
    }
}
