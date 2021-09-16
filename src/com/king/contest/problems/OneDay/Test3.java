package com.king.contest.problems.OneDay;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: LCP 33. 蓄水
 * 链接：https://leetcode-cn.com/problems/o8SXZn
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-16 20:32
 */
public class Test3 {

    public int storeWater(int[] bucket, int[] vat) {
        int maxVat = 0;
        for (int v : vat) maxVat = Math.max(v, maxVat);
        if (maxVat == 0) return 0; //最大容量为0，代表不需蓄水，直接返回0
        int ans = 10001;
        for (int pour = 1; pour <= 10000; pour++) { //枚举倒水次数1-10000
            if (pour >= ans) break;
            int upgrade = 0;
            for (int i = 0; i < vat.length; i++) { //枚举每个水桶，计算总升级次数
                int cur = (int) Math.ceil((double) vat[i] / pour - bucket[i]); //容量/倒水次数-初始蓄水量=升级次数
                upgrade += Math.max(cur, 0);
                if (upgrade >= ans) break;
            }
            ans = Math.min(ans, upgrade + pour); //倒水次数 + 总升级次数 = 总次数
        }
        return ans;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
//        输入：bucket = [1,3], vat = [6,8]
//        输出：4
        MyPrint.print(test3.storeWater(Helper.getArrays(1,3),Helper.getArrays(6,8)));
    }


}
