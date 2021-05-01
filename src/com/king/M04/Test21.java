package com.king.M04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 137. 只出现一次的数字 II
 * @author: King
 * @create: 2021-04-30 20:13
 */
public class Test21 {
    public int singleNumber(int[] nums) {
        Map<Integer , Integer> map = new LinkedHashMap<>();
        for(Integer num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return 0;
    }
}
