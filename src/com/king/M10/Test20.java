package com.king.M10;

/**
 * @program: leetcode
 * @description: 453. 最小操作次数使数组元素相等
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-20 23:14
 */
public class Test20 {

    // 优化前 2 ms
    public int minMoves1(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    // 优化后 1 ms
    //执行用时： 2 ms , 在所有 Java 提交中击败了 73.83% 的用户
    //内存消耗： 39 MB , 在所有 Java 提交中击败了 16.53% 的用户
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }


    //给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
    //输入：nums = [1,2,3]
    //输出：3
    //解释：
    //只需要3次操作（注意每次操作会增加两个元素的值）：
    //[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]


}
