package com.king.D0410;

public class Test1 {
    /**
     * 递归
     *
     * @param n
     * @return
     */
    public boolean isUgly1(int n) {
        if (n <= 0) return false;
        if (n <= 6) return true; // 1,2,3,4,5,6 都是丑数
        if (n % 2 == 0) return isUgly1(n / 2);
        if (n % 3 == 0) return isUgly1(n / 3);
        if (n % 5 == 0) return isUgly1(n / 5);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test1().isUgly2(8));
    }

    private boolean isUgly2(int n) {
        if (n <= 0) return false;
        if (n <= 6) return true; // 1,2,3,4,5,6 都是丑数
        int arr[] = new int[]{2, 3, 5};
        for (int i : arr){
            while (n % i == 0){
                n = n / i;

            }
        }
        return n == 1;
    }
}