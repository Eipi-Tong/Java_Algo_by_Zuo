package class23;

import java.io.*;

/**
 * ClassName: Algo_023_1_Quick_Sort
 * Package: class23
 * CreateTime: 2024/1/25 14:57
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_023_1_Quick_Sort {

    public static final int MAXN = (int)1e5 + 1;
    public static int[] arr = new int[MAXN];
    public static int n;  // array size

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            quickSort2(0, n - 1);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void quickSort1(int l, int r) {
        // l == r 表示就一个数；l > r 表示无效的
        if (l >= r) {
            return;
        }
        // 从 l...r上随机选一个数
        int x = arr[l + (int)(Math.random() * (r - l + 1))]; // pivot
        int mid = partition1(l, r, x);
        quickSort1(l, mid - 1);
        quickSort1(mid + 1, r);
    }

    /**
     *
     * @param l 左侧下标
     * @param r 右侧下标
     * @param x 划分的数
     * @return 划分的数所在下标
     */
    public static int partition1(int l, int r, int x) {
        int a = l; // a左侧表示 <= x 的区域，a左侧表示<a
        int xi = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(a, i); // 交换a位置和i位置的数
                xi = (arr[a] == x) ? a : xi; // 交换完了，判断x的位置
                a++;
            }
        }
        swap(a - 1, xi);
        return a - 1;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort2(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition2(l, r, x);
        // 递归会覆盖first和last的值，所以要存临时变量！！！
        int left = first, right = last;
        quickSort2(l, left - 1);
        quickSort2(right + 1, r);
    }

    public static int first, last;
    public static void partition2(int l, int r, int x) {
        /**
         * 荷兰国旗优化：分成三部分 <x; =x; >x;   优化的点是对于x能直接分出=x部分
         * a 初始化为l,左侧表示区域 <x  也就是first
         * b 初始化为r,右侧表示区域 >x  也就是last
         * i 从 l开始遍历
         * 1) if < x, swap(a, i), a++, i++
         * 2) if == x, i++
         * 3) if > x, swap(b, i), b--, i 不变
         */
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(first++, i++);
            } else {
                swap(i, last--);
            }
        }
        // 应该是要返回 a 和 b，所以有全局变量替代
    }
}

/**
 * 随机行为作为算法的重要部分时，
 * 需要按照期望来估计它的复杂度。
 *
 * 快排最差：时间复杂度O(n^2)，空间复杂度O(n)（递归n层深度）
 * 快排最优：时间复杂度O(n*log_n)，空间复杂度O(log_n)（递归log_n层深度）
 * T(N) = 2*T(N/2) + O(n)
 *
 * 如果没有随机，那么就是最差复杂度
 * 随机的话，期望时间复杂度和空间复杂度就是最优情况的。
 * 算法导论7.4.2
 */
