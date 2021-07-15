package com.king.M07;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1818. 绝对差值和
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 * @author: King
 * @create: 2021-07-14 22:45
 */
public class Test9 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        /**
         * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
         * 输出：20
         * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
         * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
         */
        Test9 t9 = new Test9();
        int a  = t9.minAbsoluteSumDiff(Helper.getArrays(1,10,4,4,2,7),Helper.getArrays(9,3,5,1,7,4));
        System.out.println(a);
    }
}
