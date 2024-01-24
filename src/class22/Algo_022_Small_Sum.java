package class22;

import java.io.*;

/**
 * ClassName: Algo_022_Small_Sum
 * Package: class22
 * CreateTime: 2024/1/24 14:51
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 小和问题：https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469

/**
 * 大范围的答案 = 左部分答案 + 右部分答案 + 左跨右的答案
 * 计算“跨越左右产生的答案”时，如果加上左、右各自有序这个设定，会不会获得计算的便利性（会）
 */
public class Algo_022_Small_Sum {

    public static final int MAXN = (int)1e6+1;
    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];
    public static int n; // array size

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
            long ans = smallSum(0, n - 1);
            out.println(ans);
        }
        out.flush();
        out.close();
    }

    public static long smallSum(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l, m) + smallSum(m + 1, r) + merge(l, m, r);   // 左 + 右 + 跨（同时排序）
    }

    public static long merge(int l, int m, int r) {
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        // 正常merge，同归并排序
        int i = l, a = l, b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = (arr[a] <= arr[b]) ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
