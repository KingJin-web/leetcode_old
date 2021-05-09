package com.king.test;

/**
 * 二分查找 ：
 * https://blog.csdn.net/zmeilin/article/details/81139814
 * https://baijiahao.baidu.com/s?id=1669750553177807262&wfr=spider&for=pc
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 12, 14, 20, 26, 30};
        System.out.println(BinarySearch(arr));
    }

    private static int BinarySearch(int[] arr) {

        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        int n = 18;
        Integer.toHexString(n);
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));
    }
}