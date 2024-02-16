package class40;

import java.io.PushbackInputStream;
import java.util.stream.StreamSupport;

/**
 * ClassName: Algo_040_N_Queens
 * Package: class40
 * CreateTime: 2024/2/9 15:45
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/n-queens-ii/description/
public class Algo_040_N_Queens {

    // 用数组表示路径实现的N皇后问题（不推荐）
    public static int totalNQueens1(int n) {
        if (n < 1) {
            return 0;
        }
        return f1(0, new int[n], n);
    }

    /**
     * @param i  当前是第i行
     * @param path  0~i-1行 皇后摆在哪里
     * @param n  一共n行
     * @return 0...i-1行已经摆完了，i....n-1行可以去尝试的情况下还能找到几种有效的方法
     */
    public static int f1(int i, int[] path, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (check(path, i, j)) {
                path[i] = j;
                res += f1(i + 1, path, n);
            }
        }
        return res;
    }

    // 当前行是i，当前列是j
    public static boolean check(int[] path, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == path[k] || Math.abs(i - k) == Math.abs(j - path[k])) {
                return false;
            }
        }
        return true;
    }

    // 用位信息表示路径实现的N皇后问题，推荐
    public static int totalNQueens2(int n) {
        if (n < 1) {
            return 0;
        }
        // n = 5
        // 1 << 5 = 0...100000 - 1
        // limit  = 0...011111;
        // n = 7
        // limit  = 0...01111111;
        int limit = (1 << n) - 1;
        return f2(limit, 0, 0, 0);
    }

    // limit : 当前是几皇后问题
    // 之前皇后的列影响：col
    // 之前皇后的右上 -> 左下对角线影响：left
    // 之前皇后的左上 -> 右下对角线影响：right
    public static int f2(int limit, int col, int left, int right) {
        if (col == limit) {
            // 所有皇后放完了！
            return 1;
        }
        // 总限制
        int ban = col | left | right;
        // ~ban : 1可放皇后，0不能放
        int candidate = limit & (~ban);
        // 放置皇后的尝试！
        int place = 0;
        // 一共有多少有效的方法
        int ans = 0;
        while (candidate != 0) {
            // 提取出最右侧的1
            // 0 0 1 1 1 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 0 0 1 0
            // candidate :
            // 0 0 1 1 0 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 0 1 0 0
            // candidate :
            // 0 0 1 0 0 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 1 0 0 0
            // candidate :
            // 0 0 0 0 0 0
            // 5 4 3 2 1 0
            place = candidate & (-candidate);
            candidate ^= place;
            ans += f2(limit, col | place, (left | place) >> 1, (right | place) << 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 14;
        long start, end;
        System.out.println("测试开始");
        System.out.println("解决" + n + "皇后问题");
        start = System.currentTimeMillis();
        System.out.println("方法1答案 : " + totalNQueens1(n));
        end = System.currentTimeMillis();
        System.out.println("方法1运行时间 : " + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        System.out.println("方法2答案 : " + totalNQueens2(n));
        end = System.currentTimeMillis();
        System.out.println("方法2运行时间 : " + (end - start) + " 毫秒");
        System.out.println("测试结束");

        System.out.println("=======");
        System.out.println("只有位运算的版本，才能10秒内跑完16皇后问题的求解过程");
        start = System.currentTimeMillis();
        int ans = totalNQueens2(16);
        end = System.currentTimeMillis();
        System.out.println("16皇后问题的答案 : " + ans);
        System.out.println("运行时间 : " + (end - start) + " 毫秒");
    }
}
