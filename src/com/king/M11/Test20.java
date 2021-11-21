package com.king.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 594. 最长和谐子序列
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-11-20 23:17
 */
public class Test20 {

    //和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
    //
    //现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
    //
    //数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。


    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1)
                begin++;
            if (nums[end] - nums[begin] == 1)
                res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    //执行用时： 18 ms , 在所有 Java 提交中击败了 43.71% 的用户 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 5.89% 的用户
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for(int num : map.keySet()){
            if(map.containsKey(num - 1))
                res = Math.max(res, map.get(num - 1) + map.get(num));
            if(map.containsKey(num + 1))
                res = Math.max(res, map.get(num + 1) + map.get(num));
        }
        return res;

    }
    public int findLHS(int[] nums) {
        HashMap <Integer, Integer> cnt = new HashMap <>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;

    }
    public static void main(String[] args) {
        //输入：nums = [1,3,2,2,5,2,3,7]
        //输出：5
        //解释：最长的和谐子序列是 [3,2,2,2,3]

        Test20 test20 = new Test20();
        int a = test20.findLHS(LeetcodeUtil.stringToIntegerArray("[1,3,2,2,5,2,3,7]"));
        MyPrint.print(a);

        short aa = -20;

        int x = 2, y = 4;
        System.out.println(++x != y--);
    }
}
