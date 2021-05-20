package MyJava.fourth;

import java.io.*;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 3、编写一个程序，从键盘编辑一个文件保存起来。
 * @author: King
 * @create: 2021-05-19 16:17
 */
public class T3 {
    public static void writeTxt(String writeFile) {
        File file = new File(writeFile);
        StringBuilder s = new StringBuilder();
        try (
                Scanner in = new Scanner(System.in);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        ) {

            String ins;
            System.out.println("请输入内容 按两次回车结束");
            while ((ins = in.nextLine()).length() >= 1) {
                //System.out.println(ins.equals(""));
                s.append(ins).append("\n");
            }
            bw.write(s.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeTxt2(String writeFile) {
        File file = new File(writeFile);
        StringBuilder s = new StringBuilder();
        try (

                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader bin = new BufferedReader(in);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        ) {

            String ins;
            System.out.println("请输入内容 输入exit结束");
            while (!(ins = bin.readLine()).equals("exit")) {
                //System.out.println(ins.equals(""));
                s.append(ins).append("\n");
            }
            System.out.println("Bye");
            bw.write(s.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        writeTxt2("D:\\write.txt");
    }
}
