package com.king.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 319. 灯泡开关
 * @author: King
 * @create: 2021-11-15 00:46
 */
public class Test15 {
//初始时有?n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
//
//第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
//
//找出并返回 n?轮后有多少个亮着的灯泡。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/bulb-switcher
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    /**
     * 初始有n个灯泡关闭
     * 第i轮的操作是每i个灯泡切换一次开关（开->闭，闭->开），即切换i的倍数位置的开关。
     * 求n轮后亮着的灯泡？
     * （1）第i轮时，被切换的灯泡位置是i的倍数。
     * （2）由（1）得出，对于第p个灯泡来说，只有其第“因子”轮才会切换，若其有q个因子，则最终被切换q次。因为初始状态是关闭状态，那么因子数是奇数的灯泡最终是亮着的。
     * （3）只有平方数的因子个数不是成对出现，举例：4=1*4,2*2，其因子是1,2,4。
     * （4）那么题目最终转化为1~n里平方数的个数，进而转化为对n开平方根，向下取整即可。
     */

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 34.8 MB , 在所有 Java 提交中击败了 96.95% 的用户
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }


    public static void main(String[] args) {
        Test15 test15 = new Test15();
        MyPrint.print(test15.bulbSwitch(3));
    }
}
class Solution {
    public boolean isRectangleCover(int[][] r) {
        //只有4个奇数次出现的坐标/
        // 面积相等
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int n = r.length;

        Set<String>set = new HashSet<>();
        int sum = 0; // 小矩形相加
        for(int i  =  0; i < n; i++){
            int []t = r[i];
            //更新大矩形四个点坐标
            left = Math.min(left, t[0]);
            bottom = Math.min(bottom, t[1]);
            right = Math.max(right, t[2]);
            top = Math.max(top, t[3]);
            //计算小矩形面积
            sum += (caculateArea(t[0], t[1], t[2], t[3]));
            //记录坐标
            String [] strings = new String[4];
            // 小矩形四个点坐标
            strings[0] = merge(t[0], t[1]);
            strings[1] = merge(t[0], t[3]);
            strings[2] = merge(t[2], t[1]);
            strings[3] = merge(t[2], t[3]);
            // 出现偶数次的抵消，奇数次保留
            for(int j = 0; j < 4; j++){
                if(set.contains(strings[j]))set.remove(strings[j]);
                else set.add(strings[j]);
            }
        }
        //最后必须只剩4个点并且set中的4个点与大矩形4个点坐标对应才表示位置匹配
        if(set.size() == 4 &&
                set.contains(merge(left, top)) &&
                set.contains(merge(left, bottom)) &&
                set.contains(merge(right, top))&&
                set.contains(merge(right, bottom))
        ){
            return sum == caculateArea(left, bottom, right, top);// 面积相等即可
        }
        return false;
    }
    int caculateArea(int left, int bottom, int right, int top){
        return (top - bottom) * (right - left);
    }
    String merge(int a, int b){
        return a + " " + b;
    }
}

作者：LittleSongFly
        链接：https://leetcode-cn.com/problems/perfect-rectangle/solution/xiao-song-man-bu-ji-suan-wei-zhi-yu-mian-ymi7/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。