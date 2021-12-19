package com.king.M12;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 419. 甲板上的战舰
 * @author: King
 * @create: 2021-12-18 23:19
 */
public class Test18 {
    //给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
    //
    //战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/battleships-in-a-board
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        String [] strings = Helper.getArrays("T0225KkcRBoQ8geCchilxvcIIACjVWnYaS5kRrbA","T0225KkcRktMplHUdhz8kaIIcACjVWnYaS5kRrbA","T0225KkcRhkd_QDWck_8wPILfQCjVWnYaS5kRrbA","T0225KkcRE9N8gXXJxj2wvALIgCjVWnYaS5kRrbA","T018v_h6QRgd_FLSIBOb1ACjVWnYaS5kRrbA","T0225KkcRBkQ9lCBIBzxxfRcIQCjVWnYaS5kRrbA","T008-bQxRxcQCjVWnYaS5kRrbA","T016aWXZlqWwIOFv975bCjVWnYaS5kRrbA","T0205KkcHkN7khOwVGGcxpVqCjVWnYaS5kRrbA","T0225KkcR08epgfUKEmgk6EJdQCjVWnYaS5kRrbA","T0205KkcKkBQkgWrYGyM45FXCjVWnYaS5kRrbA","T020u_91QBke9FTKJRP8nPAJCjVWnYaS5kRrbA","T023v_13QBYf81zKIxnwk_MCfW4CjVWnYaS5kRrbA","T014xLgwBEdH9VPXJQCjVWnYaS5kRrbA","T0077KQtGkoCjVWnYaS5kRrbA","T0157756SBod9lbfJxMCjVWnYaS5kRrbA","T022uv1yQBYe_VzTPR78nf8IfQCjVWnYaS5kRrbA","T0107KgtHldYtACjVWnYaS5kRrbA","T0205KkcPmJsoSCXc1-S56JoCjVWnYaS5kRrbA","T0225KkcRUhK8lLVJh_3lqVeIQCjVWnYaS5kRrbA","T0225KkcRBZM91PfKB-glKICJwCjVWnYaS5kRrbA","T0205KkcFEhgtCOgQX2A0r9RCjVWnYaS5kRrbA","T0225KkcRk9KoFWFJE7zwKMKdgCjVWnYaS5kRrbA","T0205KkcO2FmlBCoYGKA_qlPCjVWnYaS5kRrbA","T0225KkcRhkeplWBIR78k_cCIQCjVWnYaS5kRrbA","T020tvlySBka9F3KJxr1lP8NCjVWnYaS5kRrbA");
        System.out.println(strings.length);
    }
}
