package class100;

/**
 * ClassName: Algo_100_1_KMP
 * Package: class100
 * CreateTime: 2024/3/22 22:08
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class Algo_100_1_KMP {

    public static int strStr(String s1, String s2) {
        return kmp(s1.toCharArray(), s2.toCharArray());
    }

    public static int kmp(char[] s1, char[] s2) {
        // O(n)
        int n = s1.length, m = s2.length;
        int x = 0, y = 0;  // 分别对应s1和s2当前要比对的位置
        int[] next = nextArray(s2, m);
        while (x < n && y < m) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                // y == 0 已经考虑过了，不会到y=-1的情况
                y = next[y];
            }
        }
        return y == m ? x - y : -1; // 前者指的是s2比对完成了，此时x-y=x-m
    }

    public static int[] nextArray(char[] s2, int m) {
        // O(m)
        if (m == 1) {
            return new int[] {-1};
        }
        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;
        // i表示当前要求的next的位置
        // cn表示当前要和前一个字符比对的下标
        int i = 2, cn = next[i - 1]; // 也就是cn = 0;
        while (i < m) {
            if (s2[i - 1] == s2[cn]) {
                next[i++] = ++cn; // 就是next[i] = next[i-1] + 1, i++, cn++
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0; // 此时cn也是0
            }
        }
        return next;
    }
}
