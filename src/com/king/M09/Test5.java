package com.king.M09;

import com.king.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 470. 用 Rand7() 实现 Rand10()
 * //来源：力扣（LeetCode）
 * //链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-05 23:37
 */
public class Test5 {
    //已有方法rand7可生成 1 到 7 范围内的均匀随机整数，试写一个方法?rand10生成 1 到 10 范围内的均匀随机整数。
    //不要使用系统的Math.random()方法。
    private static class T1 {
        public int rand10() {
            int ans = rand2();
            for (int i = 0; i < 3; i++) {
                ans <<= 1;
                ans ^= rand2();
            }
            return (ans <= 10 && ans > 0) ? ans : rand10();
        }

        public int rand2() {
            int ans = rand7();
            return ans == 7 ? rand2() : ans % 2;
        }

        private int rand7() {
            Random random = new Random();
            return random.nextInt(7) + 1;
        }
    }

    //执行用时： 19 ms , 在所有 Java 提交中击败了 10.62% 的用户 内存消耗： 43.6 MB , 在所有 Java 提交中击败了 11.46% 的用户
    public int rand10() {
        return (rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7()) % 10 + 1;
    }

    private final Random random = new Random();

    private int rand7() {

        return random.nextInt(7) + 1;
    }

    public static void main(String[] args) {

        Test5 test5 = new Test5();
        T1 t1 = new T1();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 1000) {
            list.add(test5.rand10());
        }
        Helper.print(list.toArray(), 5);
    }


}
