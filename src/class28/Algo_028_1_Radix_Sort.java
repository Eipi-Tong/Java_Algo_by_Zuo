package class28;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName: Algo_028_1_Radix_Sort
 * Package: class28
 * CreateTime: 2024/1/27 12:45
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
/**
 * 基数排序 不基于比较
 * 但对于给定数组的项目有要求
 * 一般限定为10进制非负整数（其实几进制都可以，一般是10进制）
 */
public class Algo_028_1_Radix_Sort {

    public static final int MAXN = (int) 1e6+1;
    public static int[] arr = new int[MAXN];
    public static int n; // array size

    public static final int BASE = 10;
    public static int[] help = new int[MAXN];
    public static int[] cnts = new int[BASE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            doSort();
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 如果数组中的数有负数，就找到最小值，全部减去最小值，排完序后全部加上最小值即可。
    // 因此基数排序需要对每种情况都进行case by case
    public static void doSort() {
        if (arr.length <= 1) return;
        int minn = arr[0];
        for (int i = 1; i < n; i++) {
            minn = Math.min(minn, arr[i]);
        }
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= minn;    // 所有数都减去最小值，让它变正数
            maxn = Math.max(maxn, arr[i]);   // 找到其中的最大值
        }
        radixSort(bits(maxn));
        for (int i = 0; i < n; i++) {
            arr[i] += minn;    // 所有数都加上最小值，让它变成原来的值
        }
    }

    public static int bits(int num) {
        int bits = 0;
        while (num > 0) {
            num /= BASE;
            bits++;
        }
        return bits;
    }

    /**
     * 保证radixSort操作的数组 都是非负整数
     * n表示array长度，bits表示在BASE进制下最大有几位
     */
    public static void radixSort(int bits) {
        // 依次从个位到十位...，第一轮是个位
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                // 提取相应的位数并统计个数
                cnts[(arr[i] / offset) % BASE]++;
            }
            // 统计每个0-9的前缀和
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            // 从右往左遍历，分区
            for (int i = n - 1; i >= 0; i--) {
                // 相当于后面的边界，先-- 后填入， cnts也就已经--了
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }
            // 更新回原数组
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }
}
