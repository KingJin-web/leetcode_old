package com.king.M12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-12-29 20:35
 */
public class Test29 {
    //1995. 统计特殊四元组
    //给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
    //
    //nums[a] + nums[b] + nums[c] == nums[d] ，且
    //a < b < c < d


    public static void main(String[] args) {
      try(Scanner scanner = new Scanner(System.in)){
          int n = scanner.nextInt();
          List<Integer> nums = new ArrayList<>(n);
          for(int i = 0; i < n; i++){
              nums.add(scanner.nextInt());
          }

          int max = Collections.max(nums);
          int min = Collections.min(nums);
          int a = Math.abs(max - min);
          int b = Math.abs(nums.indexOf(max) - nums.indexOf(min));
          System.out.println(a + " " +b);
      }
    }


}
