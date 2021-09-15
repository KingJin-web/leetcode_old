package com.king.contest.problems.OneDay;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: LCP 28. 采购方案
 * https://leetcode-cn.com/problems/4xy4Wx/
 * @author: King
 * @create: 2021-09-15 21:55
 */
public class Test1 {
    public int purchasePlans1(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count % 1000000007;
    }

    //执行用时： 32 ms , 在所有 Java 提交中击败了 92.52% 的用户
    // 内存消耗： 48.4 MB , 在所有 Java 提交中击败了 6.61% 的用户
    public int purchasePlans(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int res = 0;
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res += (right - left);
                res %= 1000000007;//不写这一句res会超出2^32,防止越界
                left++;
            }
        }
        return res % 1000000007;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.purchasePlans(LeetcodeUtil.stringToIntegerArray("[2,2,1,9]"),10));
    }
    public int purchasePlans2(int[] nums, int target) {
        int left, right;
        int n = 0;
        Arrays.sort(nums);
        int l = nums.length;
        for (left = 0, right = l - 1; left < right; ) {
            if (nums[left] + nums[right] > target) right--;
            else {
                n = n + right - left;
                left++;
            }
        }
        return n % 1000000007;
    }
    //小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，
    // 请问他有多少种采购方案。
    //
    //注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
    //
    //示例 1：
    //
    //输入：nums = [2,5,3,5], target = 6
    //
    //输出：1
    //
    //解释：预算内仅能购买 nums[0] 与 nums[2]。
    //
    //示例 2：
    //
    //输入：nums = [2,2,1,9], target = 10
    //
    //输出：4
    //
    //解释：符合预算的采购方案如下：
    //nums[0] + nums[1] = 4
    //nums[0] + nums[2] = 3
    //nums[1] + nums[2] = 3
    //nums[2] + nums[3] = 10
    //
    //提示：
    //
    //2 <= nums.length <= 10^5
    //1 <= nums[i], target <= 10^5

}
