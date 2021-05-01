package com.king.M05;

import java.util.List;

/**
 * @program: leetcode
 * @description: 690. 员工的重要性
 * @author: King
 * @create: 2021-05-01 10:23
 */
public class Test1 {

    public static void main(String[] args) {
        int a = 1000;
        Integer a1 = new Integer(1000) ;
        Integer b1 = new Integer(1000);
        System.out.println(a1 == b1);

        Integer a2 = 100;
        Integer b2 = 100;
        System.out.println(a2 == b2);
    }
}




// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public Employee(int id, int importance) {
        this.id = id;
        this.importance = importance;
    }

    public Employee() {
    }
};
