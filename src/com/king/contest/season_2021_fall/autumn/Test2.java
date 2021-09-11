package com.king.contest.season_2021_fall.autumn;

import com.king.util.MyPrint;
import com.king.util.StringUtil;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 2. ÐÄËãÌôÕ½
 * https://leetcode-cn.com/contest/season/2021-fall/problems/uOAnQW/
 * @author: King
 * @create: 2021-09-11 16:31
 */
public class Test2 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ln = cards.length;
        int result = 0;
        int c = 0;
        for (int i = ln - 1; i >= 0 && c < 3; --i) {
            result+=cards[i];
            if (result %2 == 0){
                c++;
            }else {

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.print(test2.maxmiumScore(StringUtil.stringToIntegerArray("[1,2,8,9]"),3));
    }
}
