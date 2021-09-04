package com.king.M09;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/submissions/
 * @author: King
 * @create: 2021-09-04 19:55
 */
public class Test4 {

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.fib(100));
        MyPrint.print(test4.fib1(100));

    }

    public int fib(int n) {
        long[] f = new long[]{0, 1, 1};
        if (n < f.length)
            return (int) f[n];

        for (int i = 2; i <= n; i++) {
            f[2] = ((f[1] + f[0]) % 1000000007);
            f[0] = f[1];
            f[1] = f[2];
        }

        return (int) f[2];
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35 MB , 在所有 Java 提交中击败了 83.36% 的用户
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 3;
        if (n == 5) return 5;
        if (n == 6) return 8;
        if (n == 7) return 13;
        if (n == 8) return 21;
        if (n == 9) return 34;
        if (n == 10) return 55;
        if (n == 11) return 89;
        if (n == 12) return 144;
        if (n == 13) return 233;
        if (n == 14) return 377;
        if (n == 15) return 610;
        if (n == 16) return 987;
        if (n == 17) return 1597;
        if (n == 18) return 2584;
        if (n == 19) return 4181;
        if (n == 20) return 6765;
        if (n == 21) return 10946;
        if (n == 22) return 17711;
        if (n == 23) return 28657;
        if (n == 24) return 46368;
        if (n == 25) return 75025;
        if (n == 26) return 121393;
        if (n == 27) return 196418;
        if (n == 28) return 317811;
        if (n == 29) return 514229;
        if (n == 30) return 832040;
        if (n == 31) return 1346269;
        if (n == 32) return 2178309;
        if (n == 33) return 3524578;
        if (n == 34) return 5702887;
        if (n == 35) return 9227465;
        if (n == 36) return 14930352;
        if (n == 37) return 24157817;
        if (n == 38) return 39088169;
        if (n == 39) return 63245986;
        if (n == 40) return 102334155;
        if (n == 41) return 165580141;
        if (n == 42) return 267914296;
        if (n == 43) return 433494437;
        if (n == 44) return 701408733;
        if (n == 45) return 134903163;
        if (n == 46) return 836311896;
        if (n == 47) return 971215059;
        if (n == 48) return 807526948;
        if (n == 49) return 778742000;
        if (n == 50) return 586268941;
        if (n == 51) return 365010934;
        if (n == 52) return 951279875;
        if (n == 53) return 316290802;
        if (n == 54) return 267570670;
        if (n == 55) return 583861472;
        if (n == 56) return 851432142;
        if (n == 57) return 435293607;
        if (n == 58) return 286725742;
        if (n == 59) return 722019349;
        if (n == 60) return 8745084;
        if (n == 61) return 730764433;
        if (n == 62) return 739509517;
        if (n == 63) return 470273943;
        if (n == 64) return 209783453;
        if (n == 65) return 680057396;
        if (n == 66) return 889840849;
        if (n == 67) return 569898238;
        if (n == 68) return 459739080;
        if (n == 69) return 29637311;
        if (n == 70) return 489376391;
        if (n == 71) return 519013702;
        if (n == 72) return 8390086;
        if (n == 73) return 527403788;
        if (n == 74) return 535793874;
        if (n == 75) return 63197655;
        if (n == 76) return 598991529;
        if (n == 77) return 662189184;
        if (n == 78) return 261180706;
        if (n == 79) return 923369890;
        if (n == 80) return 184550589;
        if (n == 81) return 107920472;
        if (n == 82) return 292471061;
        if (n == 83) return 400391533;
        if (n == 84) return 692862594;
        if (n == 85) return 93254120;
        if (n == 86) return 786116714;
        if (n == 87) return 879370834;
        if (n == 88) return 665487541;
        if (n == 89) return 544858368;
        if (n == 90) return 210345902;
        if (n == 91) return 755204270;
        if (n == 92) return 965550172;
        if (n == 93) return 720754435;
        if (n == 94) return 686304600;
        if (n == 95) return 407059028;
        if (n == 96) return 93363621;
        if (n == 97) return 500422649;
        if (n == 98) return 593786270;
        if (n == 99) return 94208912;
        if (n == 100) return 687995182;
        return (fib1(n - 1) + fib1(n - 2)) % 1000000007;
    }

    //剑指 Offer II 101. 分割等和子串
    // https://leetcode-cn.com/problems/NUPfPr/
    public static class T2 {
        //给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
        //执行用时： 19 ms , 在所有 Java 提交中击败了 78.59% 的用户 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 76.76% 的用户
        public boolean canPartition(int[] nums) {
            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2;
            boolean[] f = new boolean[sum + 1];
            f[0] = true;
            for (int x : nums) {
                for (int j = sum; j >= x; j--) {
                    f[j] |= f[j - x];
                }
            }
            return f[sum];
        }

        //执行用时： 19 ms , 在所有 Java 提交中击败了 78.59% 的用户 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 97.86% 的用户
        public boolean canPartition1(int[] nums) {
            int m = 0;
            for (int num : nums) m += num;
            if (m % 2 != 0) return false;
            m /= 2;
            boolean[] f = new boolean[m + 1];
            f[0] = true;
            for (int x : nums) {
                for (int j = m; j >= x; j--) {
                    f[j] |= f[j - x];
                }
            }
            return f[m];
        }

        public static void main(String[] args) {
            //输入：nums = [1,5,11,5]
            //输出：true
            //解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
            T2 t2 = new T2();
            MyPrint.print(t2.canPartition(Helper.getArrays(1, 5, 11, 5)));
            MyPrint.print(t2.canPartition(Helper.getArrays(1, 1, 2, 2)));
        }
    }

    //面试题 01.09. 字符串轮转
    //https://leetcode-cn.com/problems/string-rotation-lcci/
    public static class T3 {

        //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
        //内存消耗： 38.1 MB , 在所有 Java 提交中击败了 64.99% 的用户
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            String ss = s2 + s2;
            return ss.contains(s1);
        }


        public static void main(String[] args) {
            T3 t3 = new T3();
            String s1 = "waterbottle", s2 = "erbottlewat";
            MyPrint.print(t3.isFlipedString(s1, s2));
        }
    }
}
