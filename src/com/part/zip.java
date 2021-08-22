package com.part;

import com.king.Helper;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-22 00:40
 */
public class zip {

    private ZipInputStream zipIn;       //解压Zip
    private ZipOutputStream zipOut;     //压缩Zip
    private ZipEntry zipEntry;
    private static int bufSize;     //size of bytes
    private byte[] buf = new byte[1024];
    private int readedBytes;

    //解压指定zip文件
    public void unZip(String unZipfileName) { //unZipfileName需要解压的zip文件名
        FileOutputStream fileOut;
        File file;

        try {
            this.zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(unZipfileName)), Charset.forName("gbk"));

            while ((this.zipEntry = this.zipIn.getNextEntry()) != null) {
                Helper.print("file: " + this.zipEntry.getName());
                file = new File("D:\\a\\" + this.zipEntry.getName());

                Helper.print("file: " + this.zipEntry.getName());
                Helper.print("filePath: " + file.getPath());
                if (this.zipEntry.isDirectory()) {
                    file.mkdirs();
                } else {
                    //如果指定文件的目录不存在,则创建之.
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    fileOut = new FileOutputStream(file);
                    while ((this.readedBytes = this.zipIn.read(this.buf)) > 0) {
                        fileOut.write(this.buf, 0, this.readedBytes);
                    }
                    fileOut.close();
                }
                this.zipIn.closeEntry();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //设置缓冲区大小
    public void setBufSize(int bufSize) {
        this.bufSize = bufSize;
    }

    public static void main(String[] args) {
        zip part21 = new zip();
        part21.unZip("D:\\a\\a.zip");
    }
}
