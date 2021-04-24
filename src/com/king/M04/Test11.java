package com.king.M04;

import com.king.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author: King
 * @create: 2021-04-23 20:58
 */
public class Test11 {
    public static void main(String[] args) {
        Test11 t11 = new Test11();
        //[2,4,3]
        //[5,6,4]
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8};
        ListNode l1 = new ListNode(arr);

        l1.println();
        System.out.println(l1);
        System.out.println(t11.listToNum(l1, 0));
        ;
        ListNode l2 = new ListNode(2, l1);


        l2.println();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        System.gc();
        return head;

    }

    public int listToNum(ListNode l, int a) {

        while (l.next != null) {

            a += l.val;
            a *= 10;
            l = l.next;
        }
        a += l.val;



        return reverse(a);
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}


class Test {
    public static void main(String[] args) {
        String a = new Scanner(System.in).next();
        int b = Integer.parseInt(a);
        System.out.printf("%d", b);
    }


}


class Person {
    private String name;
}

//成员变量：学号，（姓名），数学成绩，语文成绩，外语成绩
//成员方法：输入学生信息，计算总分，计算平均分。（注：设置各属性的方法和获取各属性的方法，以及构造方法可以根据自己的类设计自行选择定义）
//
//编程实现这个类，并在程序执行时,获取用户由键盘输入的信息,创建若干个学生类的对象(同一个班的学生,放在一个学生数组里保存)，计算并显示该班各门课程的平均成绩。
class Student extends Person {
    private int studentId;
    private String name;
    private double math;
    private double chinese;
    private double english;

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMath() {
        return math;
    }

    public double getChinese() {
        return chinese;
    }

    public double getEnglish() {
        return english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", chinese=" + chinese +
                ", english=" + english +
                '}';
    }

    public Student(int studentId, String name, double math, double chinese, double english) {
        this.studentId = studentId;
        this.name = name;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }

    public double totalScore(Student student) {
        return student.getChinese() + student.getEnglish() + student.getMath();
    }

    public double averageScore(Student student) {

        return 0;
    }

    public double[] averageScore(Student[] students) {
        double m = 0, c = 0, e = 0;
        double[] totals = totalScore(students);

        m = totals[0];
        c = totals[1];
        e = totals[2];

        m = m / students.length;
        c = c / students.length;
        e = e / students.length;
        return new double[]{m, c, e};
    }

    public double[] totalScore(Student[] students) {
        double m = 0, c = 0, e = 0;
        for (Student student : students) {
            m += student.getMath();
            c += student.getChinese();
            e += student.getEnglish();
        }
        return new double[]{m, c, e};
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "a", 150, 150, 150);
        Student s2 = new Student(1, "b", 123, 124, 124);
        Student s3 = new Student(1, "c", 142, 142, 142);
        Student s4 = new Student(1, "d", 100, 99, 90);
        Student s5 = new Student(1, "e", 50, 50, 50);
        Student[] students = new Student[]{s1, s2, s3, s4, s5};

        System.out.println("        数学   语文   英语");
        System.out.println("各科总分  " + Arrays.toString(s1.totalScore(students)));
        System.out.println("各科平均分" + Arrays.toString(s1.averageScore(students)));
    }
}