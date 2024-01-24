package class21;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

// https://www.nowcoder.com/practice/bc25055fb97e4a0bb564cb4b214ffa92
/**
 * ClassName: Algo_021_1_Merge_Sort
 * Package: class21
 * CreateTime: 2024/1/24 13:44
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_021_1_Merge_Sort {

    public static final int MAXN = 501;
    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];
    public static int n; // array size

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int)in.nval;
            }
//            mergeSort1(0, n - 1);
            mergeSort2();
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void mergeSort1(int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r);
    }

    public static void mergeSort2() {
        for (int step = 1; step < n; step <<= 1) {
            int l = 0;
            while (l < n) {
                int m = l + step - 1;
                if (m + 1 > n - 1) break;
                int r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    public static void merge(int l, int m, int r) {
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
    }
}
