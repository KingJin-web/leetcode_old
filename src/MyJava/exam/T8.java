package MyJava.exam;

import java.io.*;
import java.net.*;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-10 00:09
 */
public class T8 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器" + serverSocket.getLocalSocketAddress() + "在等待客户端链接");
        while (true) {
            Socket client = serverSocket.accept();

            System.out.println("一个新的客户端：" + client.getRemoteSocketAddress() + "链接成功");

            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dos.writeUTF("hello :" + dis.readUTF());
            dos.flush();
            os.flush();

            os.close();
            dos.close();
            client.close();
            dis.close();
        }
    }
}