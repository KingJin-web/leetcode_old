package com.king.M12;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 794. 有效的井字游戏
 * https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
 * @author: King
 * @create: 2021-12-09 23:19
 */
public class Test9 {

    //执行用时： 13 ms , 在所有 Java 提交中击败了 7.10% 的用户 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 5.33% 的用户
    public boolean validTicTacToe(String[] board) {
        // 判断在规则下，两个人轮流游戏能否形成board
        int XCount = 0, OCount = 0;
        String[] all = new String[8]; // 存储8条线的情况
        for(int i=0; i<3; i++){
            all[i] = board[i];
        }
        int idx = 3;
        for(int i=0; i<3; i++){
            String tmp = new String();
            for(int j=0; j<3; j++){
                if(board[i].charAt(j)=='X') XCount++;
                else if(board[i].charAt(j)=='O') OCount++;
                tmp += board[j].charAt(i);
            }
            all[idx++] = tmp;
        }
        all[idx++] = ""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
        all[idx] = ""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
        // 为空也行
        if(OCount+XCount==0) return true;
            // O的个数不会超过X，但X的个数不会比O多两个
        else if(OCount+2<=XCount || XCount<OCount) return false;
        else{
            int Count = XCount + OCount;
            if(Count%2==0){  // 偶数个，说明O成一条线或者两个都不成线
                for(int i=0; i<8; i++){
                    if(all[i].equals("XXX")){
                        return false;
                    }
                }
            }else{  // 奇数个，说明X成一条线或者两个都不成线
                for(int i=0; i<8; i++){
                    if(all[i].equals("OOO")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        //输入：board = ["XXX","   ","OOO"]
        //输出：false
        MyPrint.print(test9.validTicTacToe(Helper.getArrays("XXX","   ","OOO")));
    }
}
