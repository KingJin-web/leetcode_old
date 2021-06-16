package MyJava;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-19 13:13
 */
public class A {
    public static void writeTxt(String outFile) {
        File file = new File(outFile);

        try (Scanner input = new Scanner(System.in);
             FileWriter fw = new FileWriter(file, true); //表示追加
             BufferedWriter bw = new BufferedWriter(fw);
        ) {
            file.createNewFile();
            String inString;
            while ((inString = input.nextLine()).length() >= 1) {
                bw.write(inString);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void a(){
        try(FileOutputStream fs = new FileOutputStream("Test.txt")) {
            byte[] bytes = {97,98,99,100};
            fs.write(bytes);
            fs.write(bytes,0,2);
            fs.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        a();
    }

}
