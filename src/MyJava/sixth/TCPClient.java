package MyJava.sixth;

import java.io.*;
import java.net.Socket;

/**
 * @program: leetcode
 * @description: 客户端程序
 * @author: King
 * @create: 2021-06-16 16:16
 */
public class TCPClient {
    private static String host = "www.wuzhaoqi.top";
    private static int port = 59999;

    public static void main(String[] args) throws IOException {
        Socket sk = new Socket(host, port);
        try (InputStream in = sk.getInputStream();
             OutputStream out = sk.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
             BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String read, writer;
            read = br.readLine();
            System.out.println("服务器说：" + read);
            do {

                System.out.println("客户端输入：");
                writer = bin.readLine();
                bw.write(writer);
                bw.newLine();
                bw.flush();
                read = br.readLine();
                System.out.println("服务器说：" + read);


            } while (!writer.equals("bye"));

        }
    }
}
