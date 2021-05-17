package MyJava.fifth;

import java.io.*;

/**
 * @program: leetcode
 * @description: 2、	编写一个程序，将一个文本文件的内容显示到屏幕上，并复制到一个新的文本文件中。
 * @author: King
 * @create: 2021-05-19 16:03
 */
public class T2 {
    public static void readCopy(String readTxt, String writeTxt) {
        File infile = new File(readTxt);
        File outfile = new File(writeTxt);
        try (
                BufferedReader in = new BufferedReader(new FileReader(infile));
                BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
        ) {
            String s ;
            while ((s = in.readLine()) != null){
                System.out.println(s);
                out.write(s);
                out.newLine();
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readCopy("C:\\Users\\King\\Desktop\\java.txt","D:\\输出.txt");
    }
}
