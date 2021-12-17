package com.king.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1518. 换酒问题
 * //来源：力扣（LeetCode）
 * //链接：https://leetcode-cn.com/problems/water-bottles
 * //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-12-17 23:31
 */
public class Test17 {

    //小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
    //如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
    //请你计算 最多 能喝到多少瓶酒。


    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }


    public static void main(String[] args) {
        Test17 test17 = new Test17();
        MyPrint.print(test17.numWaterBottles(9,3));

    }
}
