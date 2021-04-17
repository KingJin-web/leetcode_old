package com.king.beforM04.D0224;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-24 11:44
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
       String s = "leetcode";
        System.out.println( t1.canConstruct(s,3));
    }

    public boolean canConstruct(String s, int k) {
        int length = s.length();
        if (k > length) {
            return false;
        }
        char[] array = s.toCharArray();
        int index = 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            index = array[i] - 'a';
            num ^= (1 << index);
        }
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            count++;
        }
        return count <= k;
    }
}
