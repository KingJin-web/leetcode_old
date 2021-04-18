package com.king.M04;

import java.util.*;

/**
 * @program: leetcode
 * @description: 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: King
 * @create: 2021-04-18 18:07
 */
public class Test6 {


    public static void main(String[] args) {

        //int[] nums = new int[]{-3, -1, 0, 0, 0, 3, 3};

        Test6 t6 = new Test6();
        t6.run();

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。

    }

    int[] nums = new int[]{1, 1, 2};
    //{-50, -49, -49, -46, -44, -42, -42, -41, -41, -41, -40, -40, -40, -38, -38, -37, -36, -36, -36, -35, -33, -32, -30, -29, -28, -27, -27, -27, -26, -26, -26, -26, -19, -17, -14, -14, -13, -13, -13, -13, -10, -10, -7, -7, -6, -6, -5, -5, -4, -3, -3, -3, 1, 1, 1, 2, 2, 3, 3, 5, 6, 8, 8, 9, 10, 10, 11, 12, 12, 13, 13, 14, 15, 16, 17, 17, 18, 18, 18, 18, 19, 22, 23, 24, 24, 25, 25, 26, 27, 28, 28, 28, 29, 30, 31, 32, 32, 32, 34, 35, 35, 37, 38, 39, 41, 41, 42, 42, 42, 43, 43, 44, 46, 46, 47, 49, 50, 50};

    private void run() {
        int len = removeDuplicates(nums);


// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }


    }

    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int i = 0;

//        for (int n : set) {
//
//            nums[i++] = n;
//            System.out.println(i);
//        }

        for (Integer num : nums) {
            set.add(num);
        }
        int i = 0;
        for (Integer integer : set) {
            nums[i++] = integer;
        }
        return set.size();
    }

    /**
     * 执行消耗内存为 38956 kb 的范例
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.gc();
        //运行垃圾收集器。
        //调用gc方法表明，Java虚拟机将花费更多精力来回收未使用的对象，以使它们当前占用的内存可用于快速重用。
        // 当控件从方法调用返回时，Java虚拟机将尽最大努力从所有丢弃的对象中回收空间。
        //调用System.gc()实际上等效于该调用
        return i + 1;


    }

    /**
     * 执行用时为 0 ms 的范例
     *
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }

        }
        return j + 1;

    }

}
