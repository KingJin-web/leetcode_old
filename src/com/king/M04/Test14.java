package com.king.M04;

/**
 * @program: leetcode
 * @description: 9. 回文数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-04-25 19:59
 */
public class Test14 {
    public static void main(String[] args) {
        Test14 test14 = new Test14();
        long aa = System.currentTimeMillis();
        boolean a = test14.isPalindrome(234565432);
        long bb = System.currentTimeMillis();

        System.out.println(a);
        long cc = System.currentTimeMillis();
        boolean b = test14.isPalindrome2(234565432);
        long dd = System.currentTimeMillis();
        System.out.println((bb - aa));
        System.out.println(dd - cc);
        System.out.println(b);

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x == reverse(x)) {
            return true;
        }
        return false;
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public boolean isPalindrome2(int x) {
        String s = x + "";
        StringBuffer sb = new StringBuffer(x + "");
        return sb.reverse().toString().equals(s);
    }
}
