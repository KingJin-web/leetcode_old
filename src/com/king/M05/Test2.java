package com.king.M05;

import java.util.*;

/**
 * @program: leetcode
 * @description: 1333. 餐厅过滤器
 * https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 * @author: King
 * @create: 2021-05-01 18:08
 */
public class Test2 {
    //restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。
    //                       评分     素食主义者友好     价格      距离

    /**
     * 解释：
     * 这些餐馆为：
     * 餐馆 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
     * 餐馆 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
     * 餐馆 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
     * 餐馆 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
     * 餐馆 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
     * 在按照 veganFriendly = 1, maxPrice = 50 和 maxDistance = 10 进行过滤后，我们得到了餐馆 3, 餐馆 1 和 餐馆 5（按评分从高到低排序）。
     *
     * @param restaurants
     * @param veganFriendly
     * @param maxPrice      最高价格
     * @param maxDistance   最大距离
     * @return
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> rt = new ArrayList<int[]>();//用来保存符合的情况的饭店
        List<Integer> res = new ArrayList<Integer>();//输出排序后的饭店
//        Map<Integer, Integer[]> integerMap = new HashMap<>();
        for (int[] nums : restaurants) {
            if (nums[2] >= veganFriendly && nums[3] <= maxPrice && nums[4] <= maxDistance) {
                System.out.println(Arrays.toString(nums));
                rt.add(nums);
            }
        }

        Collections.sort(rt, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {//如果的rating值相等,比较饭店的id
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < rt.size(); i++) {
            res.add(rt.get(i)[0]);
        }

        return res;
    }

    static int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};

    public static void main(String[] args) {

        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;


        List<Integer> integers = new Test2().filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        System.out.println(integers);
    }
}
