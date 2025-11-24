package client;

import java.io.*;

public class FileSaver {
    public static void save(String url, String html) throws Exception {

        String fileName = url.replace("http://", "")
                             .replace("https://", "")
                             .replace("/", "_") + ".html";

        FileWriter writer = new FileWriter(fileName);
        writer.write(html);
        writer.close();

        System.out.println("Saved as " + fileName);
    }
}
