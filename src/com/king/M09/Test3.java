package com.king.M09;

import com.king.Helper;

import java.util.*;

/**
 * @program: leetcode
 * @description: 面试题 17.14. 最小K个数
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 * @author: King
 * @create: 2021-09-03 14:16
 */
public class Test3 {
    //面试题 17.14. 最小K个数
    //设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
    //
    //示例：
    //
    //输入： arr = [1,3,5,7,2,4,6,8], k = 4
    //输出： [1,2,3,4]


    //执行用时： 7 ms , 在所有 Java 提交中击败了 64.09% 的用户
    //内存消耗： 48.2 MB , 在所有 Java 提交中击败了 30.59% 的用户
    public int[] smallestK1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        Helper.print(test3.smallestK1(Helper.getArrays(1, 3, 6, 9, 2, 1, 4, 7), 4));
        Helper.print(test3.smallestK(Helper.getArrays(1, 3, 6, 9, 2, 1, 4, 7), 4));
    }

    public int[] smallestK(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }


    public static class aa {
/*        public static void getSurveyReport1(ResultObj result, UserObj user, String survey_id, String date) throws Exception {
            if (user != null) {
                System.out.println(date);
                List<String> list = dateToWeek(date);
                System.out.println(list);
                String begin_at = list.get(0);
                String end_at = list.get(6);
                System.out.println(begin_at + "~" + end_at);
                ArrayList<ParamObj> param = new ArrayList<ParamObj>();
                if (!StringUtil.isEmpty(survey_id)) {
                    StringUtil.addParam("survey_id", survey_id, true, true, ParamObj.TYPE_EQUAL, ParamObj.COLUMN_STRING, param);
                }
                if (StringUtil.isId(begin_at)) {
                    StringUtil.addParam("create_at", begin_at, true, true, ParamObj.TYPE_BIGGER_EQUAL, ParamObj.COLUMN_STRING, param);
                }
                if (StringUtil.isId(end_at)) {
                    StringUtil.addParam("create_at", end_at, true, true, ParamObj.TYPE_LESS_EQUAL, ParamObj.COLUMN_STRING, param);
                }
                List data = SurveyAnswerSQL.getInstance().doQuery(-1, "create_at", "desc", param);

                //name: '核验价大全',
                Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
                //name: '魔都财观',
                Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
                //name: '新房指南',
                Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
                //name: '升学大全',
                Map<Integer, Integer> map4 = new HashMap<Integer, Integer>();
                //name: '买房攻略',
                Map<Integer, Integer> map5 = new HashMap<Integer, Integer>();
                //name: '平米房产咨询',
                Map<Integer, Integer> map6 = new HashMap<Integer, Integer>();
                //name: '平米房产服务号',
                Map<Integer, Integer> map7 = new HashMap<Integer, Integer>();
                //name: '抖音赵公子',
                Map<Integer, Integer> map8 = new HashMap<Integer, Integer>();
                if (data != null) {
                    for (Object o : data) {
                        String a = o.toString();
                        //System.out.println(a);
                        int index = a.indexOf("\"update_at\":\"") + 13;
                        //得到这是这周第几天
                        int da = list.indexOf(a.substring(index, index + 10));
                        //System.out.println(da);
                        if (a.contains("核验价大全")) {
                            map1.put(da, map1.getOrDefault(da, 1) + 1);
                        } else if (a.contains("魔都财观")) {
                            map2.put(da, map2.getOrDefault(da, 1) + 1);
                        } else if (a.contains("新房指南")) {
                            map3.put(da, map3.getOrDefault(da, 1) + 1);
                        } else if (a.contains("升学大全")) {
                            map4.put(da, map4.getOrDefault(da, 1) + 1);
                        } else if (a.contains("买房攻略")) {
                            map5.put(da, map5.getOrDefault(da, 1) + 1);
                        } else if (a.contains("平米房产咨询")) {
                            map6.put(da, map6.getOrDefault(da, 1) + 1);
                        } else if (a.contains("平米房产服务号")) {
                            map7.put(da, map7.getOrDefault(da, 1) + 1);
                        } else if (a.contains("抖音赵公子")) {
                            map8.put(da, map8.getOrDefault(da, 1) + 1);
                        }
                    }

                }
                result.setStatus(true);
                result.setData(mapToArr(map1, map2, map3, map4, map5, map6, map7, map8));
                result.setMessage(begin_at + "~" + end_at);*/

        //}
        @SafeVarargs
        public static int[][] mapToArr(Map<Integer, Integer>... maps) {
            int[][] result = new int[8][7];
            int index = 0;
            for (Map<Integer, Integer> map : maps) {
                int[] arr = new int[7];
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                    arr[entry.getKey()] = entry.getValue();
                }
                result[index++] = arr;
            }
            return result;


        }
    }


}
