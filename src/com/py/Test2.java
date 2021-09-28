package com.py;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 2、/*实现遍历D:\test\src目录下的所有图片(jpg)
 * @author:King
 * @create:2021-09-28 19:15
 */

public class Test2 {
    static List<File> jpgFiles = new ArrayList<>();
    public static void findAllJpg(File file){

        if(!file.exists()){
            System.out.println("文件或目录不存在!");
            return;
        }
        File[] fileArray= file.listFiles();

        for (File file1:fileArray){
            if (file1.isDirectory()){
                findAllJpg(file1);
            }else if (file1.getName().endsWith(".jpg")){
                jpgFiles.add(file1);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\test\\src\\");
        findAllJpg(file);
        jpgFiles.forEach(System.out::println);
    }
}
