package com.king.M12;

import com.king.util.MyPrint;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 1705. 吃苹果的最大数目
 * @author: King
 * @create: 2021-12-24 23:35
 */
public class Test24 {
    //982ms
    public int eatenApples(int[] apples, int[] days) {
        int count=0;
        int[] dp = new int[apples.length+20000]; //用dp数组标志已结算的苹果
        for(int i = apples.length-1;i>=0;i--){
            for(int j=i + days[i] - 1;j>=i && apples[i]>0;j--){ //遍历从未开始结算处开始填充苹果
                if(dp[j]==0){
                    dp[j] = Math.max(j - apples[i] + 2, i + 1);
                    count++;
                    apples[i]--;
                }else{
                    j = dp[j] - 1;
                }
            }
        }
        return count;
    }
    //691ms
    public int eatenApples5(int[] apples, int[] days) {
        int count=0;
        int[] dp = new int[apples.length+20000]; //用dp数组标志已结算的苹果
        for(int i = apples.length-1;i>=0;i--){
            int app = apples[i];
            for(int j=i + days[i] - 1;j>=i && app>0;j--){ //遍历从未开始结算处开始填充苹果
                if(dp[j]==0){
                    dp[j]=1;
                    count++;
                    app--;
                }
            }
        }
        return count;
    }
    //298ms
    public int eatenApples4(int[] apples, int[] days) {
        int day = 0;
        //找出苹果还未全部腐烂的最后日期
        for (int i = 0; i < days.length; i++) {
            day = Math.max(i + days[i], day);
        }
        //下标值表示失效日期，存储在当天后即腐烂的苹果数
        int[] tmp = new int[day];
        int res = 0;
        for (int i = 0; i < day; i++) {
            //保存当天新长出的苹果
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
            }
            int idx = i;
            //取出最先腐烂的苹果
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            //有苹果就拿出来吃掉
            if (idx != day) {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
    //116ms
    public int eatenApples3(int[] apples, int[] days) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b){
                return (a[1]+a[2]) - (b[1]+b[2]);
            }
        });
        int max=0;
        for(int i = 0;i < apples.length+20000; i++){
            //放入当天的苹果
            if(i < apples.length &&apples[i] > 0 && days[i]>0)
                queue.add(new int[]{apples[i],i,days[i]});
            //吃最早过期的苹果
            if(!queue.isEmpty()){
                int[] cur = queue.poll();
                if(cur[0]-- > 0 && i < cur[1] + cur[2]){
                    if(cur[0] > 0)
                        queue.offer(cur);
                    max++;
                }
            }
            //取出今天过期的苹果
            while(!queue.isEmpty() && i + 1== queue.peek()[1] + queue.peek()[2])
                queue.poll();
        }
        return max;
    }
    //9ms
    public int eatenApples2(int[] apples, int[] days) {
        int day = 0;
        //找出苹果还未全部腐烂的最后日期
        for (int i = 0; i < days.length; i++) {
            day = Math.max(i + days[i], day);
        }
        //下标值表示失效日期，存储在当天后即腐烂的苹果数
        int[] tmp = new int[day];
        int curMax = day,res = 0;
        for (int i = 0; i < day; i++) {
            //保存当天新长出的苹果
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
                curMax = Math.min(curMax,i + days[i] - 1);
            }
            //有苹果就拿出来吃掉
            int idx = Math.max(i,curMax);
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            if (idx != day) {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
    //2ms
    public int eatenApples1(int[] apples, int[] days) {
        if(apples.length==1) return  Math.min(days[0],apples[0]);
        int n=apples.length,EndDay=0,ZeroDay=0;
        for(int i=0;i<n;++i){
            if(apples[i] != 0 && i+days[i] > EndDay)
                EndDay = i + days[i];
            if(i >= EndDay) //空闲的天数
                ZeroDay++;
        }
        return EndDay - ZeroDay;
    }

    public static void main(String[] args) {
        Test24 test = new Test24();

        int [] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
        MyPrint.print(test.eatenApples(apples,days));
    }

    //有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
    //
    //你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
    //
    //给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
    //
    //?
    //
    //示例 1：
    //
    //输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
    //输出：7
    //解释：你可以吃掉 7 个苹果：
    //- 第一天，你吃掉第一天长出来的苹果。
    //- 第二天，你吃掉一个第二天长出来的苹果。
    //- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
    //- 第四天到第七天，你吃的都是第四天长出来的苹果。
    //示例 2：
    //
    //输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
    //输出：5
    //解释：你可以吃掉 5 个苹果：
    //- 第一天到第三天，你吃的都是第一天长出来的苹果。
    //- 第四天和第五天不吃苹果。
    //- 第六天和第七天，你吃的都是第六天长出来的苹果。
    //?
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
}
