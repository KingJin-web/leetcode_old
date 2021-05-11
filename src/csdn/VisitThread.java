package csdn;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-11 19:46
 */
import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.URL;

public class VisitThread extends Thread {
    private String url;

    public VisitThread(String url){
        this.url = url;

    }

    public void run() {
        for(int i=1; i<=20000; i++){
            try {
                visit(url);

            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }

    public void visit(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestProperty("User-Agent", "");

        connection.getInputStream();

        connection.disconnect();



    }

}
