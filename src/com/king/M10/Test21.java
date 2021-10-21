package com.king.M10;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 * @author: King
 * @create: 2021-10-21 19:40
 */
public class Test21 {
    //如果 digits 的末尾没有 9 将末尾的数加一
//
//如果 digits 的末尾有若干个 9只需要找出从末尾开始的第一个不为 9 的元素，将该元素加一，得到随后将末尾的 9 全部置零
//
//如果 digits 的所有元素都是 9，构造一个长度比digits 多 11 的新数组，将首元素置为 1，其余元素置为 0 即可。
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.8 MB , 在所有 Java 提交中击败了 68.73% 的用户
    public int[] plusOne(int[] digits) {
        int ln = digits.length;
        if (digits[ln - 1] != 9) {
            ++digits[ln - 1];
        } else {
            int i = ln - 1;
            while (digits[i] == 9) {
                if (i == 0) {
                    // digits 中所有的元素均为 9
                    int[] ans = new int[ln + 1];
                    ans[0] = 1;
                    return ans;
                }
                digits[i--] = 0;
            }
            ++digits[i];
        }
        return digits;
    }
    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
    public static void main(String[] args) {
        Test21 test21 = new Test21();
        MyPrint.print(test21.plusOne(Helper.getArrays(8, 8, 9, 9)));
    }
}
