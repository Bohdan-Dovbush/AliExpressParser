package Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class save{

    public static String saveIs(String urL){
        try {
            URL url = new URL(urL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String readLine;
            StringBuilder buffer = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((readLine = br.readLine()) != null) {
                buffer.append(readLine);
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
