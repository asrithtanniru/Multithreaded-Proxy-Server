package server.utils;

import java.io.*;
import java.net.*;

public class HttpFetcher {

    public static String fetch(String urlStr) throws Exception {
        StringBuilder builder = new StringBuilder();

        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        InputStream inputStream;
        if (status >= 200 && status < 400) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();
        connection.disconnect();

        return builder.toString();
    }
}
