package com.king.M08;

import com.king.Helper;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-01 14:46
 */
public class Test1 {
    public static T1 t1 = new T1();

    /**
     * 1337. 矩阵中战斗力最弱的 K 行
     * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
     */
    public static class T1 {

        // 二分 + 大根堆
        // 时间：O(M*logN + M*logK)
        // 空间：O(M + K)
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
            // 1）统计每行的军人数量，填入arr数组
            int[][] arr = new int[m][2]; // arr[i][0]：第i行的军人数量，arr[i][1]：行号i
            for (int i = 0; i < m; i++) {
                int index = findTheMostRightOne(mat[i]); // 二分查找
                arr[i] = new int[]{index + 1, i};
            }
            // 2）使用容量为k的大根堆，堆顶维护"门槛"，容量满了后，只有"干掉"门槛，方可入堆
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]));
            for (int[] row : arr) {
                if (maxHeap.size() < k) maxHeap.add(row); // 容量未满，直接入堆
                else { // maxHeap.size() == k ，大根堆满了
                    int[] peek = maxHeap.peek();

                    if (row[0] < peek[0] || (row[0] == peek[0] && row[1] < peek[1])) {
                        maxHeap.poll(); // 干掉门槛
                        maxHeap.add(row); // 方可入堆
                    }
                }
            }
            // 3）从大根堆依次弹出元素，构建答案
            int[] ans = new int[k];
            while (k >= 1) {
                ans[--k] = maxHeap.poll()[1];
            }
            return ans;
        }

        // 二分查找，找到最右侧的1，将下标返回，如果没有，返回-1
        private int findTheMostRightOne(int[] arr) {
            int l = 0, r = arr.length - 1, index = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (arr[m] == 1) { // 找到了1，记录下此时index，再看右侧是否还有更右的
                    index = m;
                    l = m + 1;
                } else { // 左侧二分
                    r = m - 1;
                }
            }
            return index;
        }

        public static void main(String[] args) {
            int[][] a = new int[][]{
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 1}};
            Helper.print(t1.kWeakestRows(a, 3));


        }
    }

    /**
     * 5830. 三除数
     */
    public static class T2{

    }
}
