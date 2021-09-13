package com.util.myzip;

import cn.hutool.core.util.ZipUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-13 19:01
 */
public class ZipHelper {
    private String ZipPath;

    private ZipHelper() {
    }

    private final static ZipHelper instance = new ZipHelper();

    public static ZipHelper getInstance(String ZipPath) {
        instance.ZipPath = ZipPath;
        return instance;
    }

    public ZipFileNode getZipFileTree() {
        File file = new File(ZipPath);
        ZipFile zipFile = null;
        ZipInputStream zin = null;
        FileInputStream fis = null;
        try {
            Charset gbk = Charset.forName("GBK");
            zipFile = new ZipFile(file, gbk);
            fis = new FileInputStream(file);
            zin = new ZipInputStream(fis, gbk);

            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {
                String path = ze.getName();
                System.out.println(path);
                if (!ze.isDirectory() && ze.toString().endsWith("txt")) {
                    InputStream inputStream = zipFile.getInputStream(ze);
//                    List<String> texts = IOUtils.readLines(inputStream);
//                    for (String text : texts) {
//                        System.out.println("  " + text);
//                    }
                    inputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zin != null) {
                    zin.closeEntry();
                    zin.close();
                }
                if (fis != null)
                    fis.close();
                if (zipFile != null)
                    zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ZipFileNode();
    }


    public static boolean UnZipInTxt(String zipPath, String outPath) {
        File infile = new File(zipPath); //解压文件
        File outfile = null; //解压到的目录
        if (outPath.equals("")) {
            outPath = infile.getParentFile().getPath();
        }
        byte[] buf = new byte[1024];
        int readedBytes;
        if (!infile.exists() || !zipPath.endsWith(".zip")) {
            System.out.println("文件不存在，或文件不是zip文件");
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
            return false;
        }

        return true;
    }
}
