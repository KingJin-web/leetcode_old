package com.king.M10;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description: 剑指 Offer II 069. 山峰数组的顶部
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/B1IidL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-14 00:04
 */
public class Test14 {

    //符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
    //
    //arr.length >= 3
    //存在 i（0 < i< arr.length - 1）使得：
    //arr[0] < arr[1] < ... arr[i-1] < arr[i]
    //arr[i] > arr[i+1] > ... > arr[arr.length - 1]
    //给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    // 的下标 i?，即山峰顶部。

    //执行用时： 5 ms , 在所有 Java 提交中击败了 11.08% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 42.30% 的用户
    public int peakIndexInMountainArray1(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return a.indexOf(max);
    }

    // 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 85.00% 的用户
    public int peakIndexInMountainArray2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }
    //时间复杂度：O(n)
    //空间复杂度：O(1)


    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    //时间复杂度：O(\log n)
    //空间复杂度：O(1)

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        int n1 = test14.peakIndexInMountainArray(LeetcodeUtil.stringToIntegerArray(" [24,69,100,99,79,78,67,36,26,19]"));
        MyPrint.print(n1);
    }

}
