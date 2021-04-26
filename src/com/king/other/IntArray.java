package com.king.other;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 定义一个名为IntArray的整型数组操作类，并实现其方法。它的UML图如下，先实现该类的相关方法，再试编写一个类来测试该类这些的方法。
 * @author: King
 * @create: 2021-04-26 22:15
 */
public class IntArray {
    private int[] array;

    public IntArray() {

    }

    public IntArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getMaxElem() {
        Arrays.sort(this.array);
        return this.array[this.array.length - 1];
    }

    public int getMinElem() {
        Arrays.sort(this.array);
        return this.array[0];
    }

    public int getSumElem() {
        int temp = 0;
        for (int i = 0; i < this.array.length; i++) {
            temp += this.array[i];
        }
        return temp;
    }

    public double getAvgElem() {
        return (double) this.getSumElem() / this.array.length;
    }

    public int[] getSortedElem() {
        Arrays.sort(this.array);
        return this.array;
    }

    public boolean isPrimeOfMaxElem() {
        int num = this.getMaxElem();
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isFindElem(int x) {
        for (int num : this.array) {
            if (num == x) {
                return true;
            }
        }
        return false;
    }

    public void printElem() {
        for (int i = 0; i < this.array.length; i++) {

            System.out.print(this.array[i] + ", ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 324, 53, 13, 45, 312, 54, 1321, 54, 4124, 54, 341, 23532, 11, 111111};
        IntArray array = new IntArray(arr);
        System.out.println(Arrays.toString(array.getArray()));
        System.out.println(array.getMaxElem());
        System.out.println(array.getMinElem());
        System.out.println(array.getSumElem());
        System.out.println(array.getAvgElem());

        System.out.println(Arrays.toString(array.getSortedElem()));

        System.out.println(array.isPrimeOfMaxElem());
        System.out.println(array.isFindElem(21));
        System.out.println(array.isFindElem(22));

        array.printElem();


    }
}