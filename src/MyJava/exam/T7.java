package MyJava.exam;

import java.io.*;
import java.net.*;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-10 00:08
 */
public class T7 {
    public static int port = 9999;

    public static void main(String[] args) throws IOException {

        Socket client = new Socket(InetAddress.getLocalHost(), port);
        //客户端链接服务器 9999 端口 并随机选用一个端口作为发送端

        OutputStream os = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        InputStream is = client.getInputStream();
        DataInputStream dis = new DataInputStream(is);


        String name = "我是客户端一号";
        dos.writeUTF(name);
        dos.flush();
        System.out.println("客户端发送: " + name);
        String s;
        if ((s = dis.readUTF()) != null) {
            System.out.println("服务器的问候为: " + s);
        }
        client.close();
        dos.close();
        dis.close();
    }
}
