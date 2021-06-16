package MyJava.sixth;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-06-16 16:04
 */
public class TCPServer implements Runnable {
    private Socket socket;
    private Scanner in = new Scanner(System.in);

    public TCPServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(59999);
        while (true) {
            //接受连接,每个TCP连接都是一个java线程
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new TCPServer(clientSocket)).start();
            }
        }
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            String clientAddress = socket.getInetAddress().getHostAddress();
            String clientHostName = socket.getInetAddress().getHostName();
            System.out.println(clientHostName + "(" + clientAddress + ")" + " 连接成功!");
            String read, writer;
            writer = "欢迎" + clientAddress + "!";
            bw.write(writer);
            bw.newLine();
            bw.flush();
            do {
                read = br.readLine();
                System.out.println("客户端说：" + read);
                System.out.println("服务器输入：");
                writer = in.nextLine();
                bw.write(writer);
                bw.newLine();
                bw.flush();
            } while (!read.equals("bye"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
