package com.interview.test1;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-29 15:23
 */
public class Test1 {
    int[] sortValues(int [] originValues){
        int ln = originValues.length;
        int temp = 0;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln; j++) {
                if (originValues[i] < originValues[j]){
                    temp = originValues[i];
                    originValues[i] = originValues[j];
                    originValues[j] = temp;
                }
            }
        }
        return originValues;
    }
    void sort(int [] originValues){
        int ln = originValues.length;
        int temp = 0;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln; j++) {
                if (originValues[i] < originValues[j]){
                    temp = originValues[i];
                    originValues[i] = originValues[j];
                    originValues[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int [] arr = Helper.getArrays(1,2,89,36,88,52,6985,-22);
        MyPrint.print(test1.sortValues(arr));
        MyPrint.print("ÅÅÐòÇ°" + arr);
    }
}
