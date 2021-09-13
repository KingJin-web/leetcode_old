package com.util.myzip;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-13 19:05
 */
public class ZipTest {
    public static void main(String[] args) {
        ZipHelper zipHelper = ZipHelper.getInstance("D:\\testZip.zip");
        ZipFileNode zipFileNode = zipHelper.getZipFileTree();
        System.out.println(zipFileNode);
    }
}
