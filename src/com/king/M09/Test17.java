package com.king.M09;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 36. 有效的数独
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-17 14:54
 */
public class Test17 {
    //执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38 MB , 在所有 Java 提交中击败了 96.08% 的用户
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blks = new int[9];
        for (int ri = 0; ri < 9; ++ri) {
            for (int ci = 0; ci < 9; ++ci) {
                if (board[ri][ci] != '.') {
                    int bi = ri / 3 * 3 + ci / 3;
                    int uvb = 1 << (board[ri][ci] - '0');
                    if ((uvb & (rows[ri] | cols[ci] | blks[bi])) != 0)
                        return false;
                    rows[ri] |= uvb;
                    cols[ci] |= uvb;
                    blks[bi] |= uvb;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Test17 test17 = new Test17();
        MyPrint.print(test17.isValidSudoku(chars));

    }
}
//            Arrays.sort(nums, Collections.reverseOrder());
//            Arrays.sort(nums, (Integer a, Integer b) -> { return b-a; });