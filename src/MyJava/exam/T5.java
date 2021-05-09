package MyJava.exam;

import java.io.*;

/**
 * @program: leetcode
 * @description: //5，编程序将D:\MyJava\1MG.jpg图片复制到D:\Pic.jpg
 * @author: King
 * @create: 2021-05-10 00:04
 */
public class T5 {
    /**
     * 实现文件的复制粘贴
     *
     * @param oldFile
     * @param newFile
     * @throws IOException
     */
    public static void copyFile(String oldFile, String newFile) {
        File srcFile = new File(oldFile);
        File targetFile = new File(newFile);

        if (!srcFile.exists()) {
            System.out.println("文件不存在");
            return;
        }
        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(targetFile);
        ) {
           // targetFile.createNewFile();
            //根据抽象路径创建一个新的空文件，当抽象路径制定的文件存在时，创建失败。
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件复制成功");


    }

    /**
     * 实现文件的复制粘贴
     * 更快
     *
     * @param oldFile
     * @param newFile
     * @throws IOException
     */
    public static void copyFile2(String oldFile, String newFile) {
        File srcFile = new File(oldFile);
        File targetFile = new File(newFile);
        if (!srcFile.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (InputStream in = new FileInputStream(srcFile);
             BufferedInputStream bin = new BufferedInputStream(in);
             OutputStream out = new FileOutputStream(targetFile);
             BufferedOutputStream bout = new BufferedOutputStream(out);
        ) {
            //targetFile.createNewFile();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件复制成功");

    }

    public static void main(String[] args) {
        T5.copyFile("D:\\MyJava\\1MG.jpg", "D:\\Pic.jpg");
        T5.copyFile2("D:\\MyJava\\1MG.jpg", "D:\\Pic.jpg");
    }

}