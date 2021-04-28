package com.king.M04;

/**
 * @program: leetcode
 * @description: 657. 机器人能否返回原点
 * @author: King
 * @create: 2021-04-28 20:00
 */
public class Test19 {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了41.67%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了50.78%的用户
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {

        char[] ch = toCharArray(moves, moves.length());
        int r = 0, l = 0;
        int u = 0, d = 0;
        for (char c : ch) {
            if (c == 'R') {
                r++;
                continue;
            }
            if (c == 'L') {
                l++;
                continue;
            }
            if (c == 'U') {
                u++;
                continue;
            }
            if (c == 'D') {
                d++;

            }
        }
        if (l == r && u == d) {
            return true;
        }
        return false;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了26.70%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了95.95%的用户
     * @param moves
     * @return
     */
    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        int i, l = moves.length();
        char c;
        for (i = 0; i < l; i++) {
            c = moves.charAt(i);
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            }
        }
        System.gc();
        return x == y && y == 0;
    }

    public char[] toCharArray(String str, int length) {

        char[] ch = new char[length];

        for (int i = 0; i < length; i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(new Test19().judgeCircle2("RRDD"));
        System.out.println(new Test19().judgeCircle2("RRDDLLUU"));
    }


    /**
     *执行用时：12 ms, 在所有 Java 提交中击败了16.66%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了5.06%的用户
     * @param moves
     * @return
     */
    public boolean judgeCircle3(String moves) {
        return (moves.replace("U","").length()==moves.replace("D","").length()&&moves.replace("L","").length()==moves.replace("R","").length());
    }

}
