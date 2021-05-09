package MyJava.exam;

import java.io.*;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: //6，编程序从键盘写日记到D: \日记. txt中。
 * @author: King
 * @create: 2021-05-10 00:04
 */
public class T6 {

    public static void writeTxt(String outFile) throws IOException {
        File file = new File(outFile);
        file.createNewFile();
        try (Scanner input = new Scanner(System.in);
             FileWriter fw = new FileWriter(file, true); //表示追加
             BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String inString;
            //当输入为空时结束
            while ((inString = input.nextLine()).length() >= 1) {
                bw.write(inString);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        T6.writeTxt("D:/日记.txt");
    }

}