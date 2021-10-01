package com.king.M10;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 1436. 旅行终点站
 * //来源：力扣（LeetCode）
 * //链接：https://leetcode-cn.com/problems/destination-city
 * //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-01 22:31
 */
public class Test1 {
    //给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
    //
    //题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 5.00% 的用户
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> list : paths) {
            set.add(list.get(0));
        }
        for (List<String> list : paths) {
            String s = list.get(1);
            if (set.add(s)) {
                return s;
            }
        }
        return "";
    }

    //执行用时： 2 ms , 在所有 Java 提交中击败了 94.47% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 22.89% 的用户
    public String destCity1(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        //[["B","C"],["D","B"],["C","A"]]
        list.add(Helper.getList("B","C"));
        list.add(Helper.getList("D","B"));
        list.add(Helper.getList("C","A"));
        Test1 test1 = new Test1();
        MyPrint.print(test1.destCity(list));
    }

}
