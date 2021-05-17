package com.king.M05;

/**
 * @program: leetcode
 * @description: 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 * @author: King
 * @create: 2021-05-18 00:20
 */
public class Test19 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了50.79%的用户
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }

        int n = s.lastIndexOf(" ");

        if (n == -1) {
            return s.length();
        }
        return s.substring(n + 1).length();
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了99.89%的用户
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        int count=0,flag;
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)==' '){ i--;}
            else{
                while(i>=0&&s.charAt(i)!=' ')
                {count++;i--;}
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new Test19().lengthOfLastWord(s));
    }

}
