package com.part;


import com.king.Helper;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @program: leetcode
 * @description: 写?个程序，能够解压附件 2.1.zip 中的所有后缀为txt的?本?件。 注意:
 * 1. 附件?还包括其他?件，我们只要解压txt?件。
 * 2. 压缩包??还可能有压缩包
 * 3. 是你??写?个程序完成解压，可以调?第三?库，但不能使?外部的软件来解压。
 * @author: King
 * @create: 2021-08-21 22:26
 */
public class part2_1 {


    /**
     * 解压 指定压缩文件中所有 .txt文件
     *
     * @param zipPath 压缩文件路径
     * @param outPath 解压文件路径 如果为空就会默认解压到压缩文件目录下
     * @return
     */
    public static boolean UnZipInTxt(String zipPath, String outPath) {
        File infile = new File(zipPath); //解压文件
        File outfile = null; //解压到的目录
        if (outPath.equals("")) {
            outPath = infile.getParentFile().getPath();
        }
        byte[] buf = new byte[1024];
        int readedBytes;
        if (!infile.exists() || !zipPath.endsWith(".zip")) {
            System.out.println("文件不存在，或文文件不是zip文件");
            return false;
        }
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(infile)), Charset.forName("gbk"))) {
            ZipEntry zipEntry = null;
            String fileName;
            while ((zipEntry = zis.getNextEntry()) != null) {

                fileName = zipEntry.getName(); //获取文件名
                if (fileName.endsWith(".txt")) {
                    outfile = new File(outPath + "\\" + zipEntry.getName()); //获得解压目标路径
                    //如果指定文件的目录不存在,则创建之.
                    File parent = outfile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outfile))) {
                        while ((readedBytes = zis.read(buf)) > 0) {
                            bos.write(buf, 0, readedBytes);
                        }
                    }
                } else {
                    if (zipEntry.isDirectory()) {
                        outfile = new File(outPath + "\\" + zipEntry.getName()); //获得解压目标路径
                        System.out.println(outfile.getPath());
                        outfile.mkdirs();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        UnZipInTxt("D:\\a\\a.zip", "");
    }

}



