package com.interview.py;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: leetcode
 * @description: 3、/*用java实现统计D:\test\src下test.txt文件中出现字母的个数
 * @author: King
 * @create: 2021-09-28 19:27
 */
public class Test3 {
    public static int test(File file) {
        if (!file.exists()) {
            System.out.println("文件或目录不存在!");
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));) {
            String s = null;
            while ((s = br.readLine()) != null) {
                //使用readLine方法，一次读一行
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        char [] chars = sb.toString().toCharArray();
        int count = 0;
        for (char c : chars){
            if (Character.isLowerCase(c) || Character.isUpperCase(c)){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        File file = new File("D:\\test\\src\\test.txt");
        System.out.println(test(file));
    }
}
