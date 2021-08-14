package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 1929. ���鴮��
 * https://leetcode-cn.com/problems/concatenation-of-array/
 * @author: King
 * @create: 2021-07-30 14:50
 */
public class Test34 extends Helper {
    public static Test34 t34 = new Test34();
    public T1 t1 = new T1();
    public T2 t2 = new T2();

    /**
     * @program: leetcode
     * @description: 1929. ���鴮��
     * https://leetcode-cn.com/problems/concatenation-of-array/
     * @author: King
     * @create: 2021-07-30 14:50
     */
    public static class T1 {
        /**
         * ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 92.43% ���û�
         * �ڴ����ģ� 39.2 MB ,������ Java �ύ�л����� 24.57% ���û�
         *
         * @param nums
         * @return
         */
        public int[] getConcatenation1(int[] nums) {
            int[] arr = new int[nums.length * 2];
            for (int i = 0; i < nums.length; ++i) {
                arr[i] = nums[i];
                arr[i + nums.length] = nums[i];
            }

            return arr;
        }

        public int[] getConcatenation(int[] nums) {
            int l = nums.length;
            int[] arr = new int[nums.length * 2];
            for (int i = 0; i < nums.length; ++i) {
                arr[i] = nums[i];
                arr[i + nums.length] = nums[i];
            }

            return arr;
        }

        public static void main(String[] args) {
            int[] arr = t34.t1.getConcatenation(Helper.getArrays(1, 2, 3, 4, 5, 6));
            Helper.print(arr);

        }
    }

    /**
     * @program: leetcode
     * @description: 1920. �������й�������
     * https://leetcode-cn.com/problems/build-array-from-permutation/
     * @author: King
     * @create: 2021-07-30 14:50
     */
    public static class T2 {
        /**
         * ִ����ʱ�� 3 ms , ������ Java �ύ�л����� 100.00% ���û�
         * �ڴ����ģ� 37.6 MB , ������ Java �ύ�л����� 100.00% ���û�
         *
         * @param nums
         * @return
         */
        public int[] buildArray(int[] nums) {
            int[] arr = new int[nums.length];

            for (int i = 0; i < nums.length; ++i) {
                arr[i] = nums[nums[i]];
            }
            System.gc();
            return arr;
        }

        public static void main(String[] args) {
            Helper.print(t34.t2.buildArray(Helper.getArrays(5, 0, 1, 2, 3, 4)));
        }
    }

    public static class T3 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            double a = in.nextDouble();
            int b = (int) a;
            int ʮԪ = b / 10;
            int ��Ԫ = (b - ʮԪ * 10 - 5) >= 0 ? 1 : 0;
            int һԪ = b - (ʮԪ * 10 + ��Ԫ * 5);
            System.out.println(ʮԪ + ":" + ��Ԫ + ":" + һԪ);

            int al = (int) (Math.round(a * 100) / 100.0);
            print(al);

            in.close();
        }
    }


}