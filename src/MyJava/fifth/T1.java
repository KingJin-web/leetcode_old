package MyJava.fifth;

import java.io.*;

/**
 * @program: leetcode
 * @description: 1、	编写一个程序，将一个图片文件换个名字复制到另一个盘中
 * @author: King
 * @create: 2021-05-19 15:56
 */
public class T1 {

    /**
     * 实现文件的复制粘贴
     * 更快
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
        copyFile("C:\\Users\\King\\Pictures\\2.jpg","D\\1.jpg");
    }
}