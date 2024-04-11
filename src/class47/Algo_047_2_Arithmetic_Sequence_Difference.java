package class47;

import java.io.*;

/**
 * ClassName: Algo_047_2_ArithmeticSequenceDifference
 * Package: class47
 * CreateTime: 2024/4/10 23:39
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_047_2_Arithmetic_Sequence_Difference {

    public static final int MAXN = (int) 1e7+5;
    public static long[] arr = new long[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken(); int l = (int) in.nval;
                in.nextToken(); int r = (int) in.nval;
                in.nextToken(); int s = (int) in.nval;
                in.nextToken(); int e = (int) in.nval;
                set(l, r, s, e, (e - s) / (r - l));
            }
            build(n);
            long xor = 0, maxn = 0;
            for (int i = 1; i <= n; i++) {
                xor ^= arr[i];
                maxn = Math.max(maxn, arr[i]);
            }
            out.println(xor + " " + maxn);
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void set(int l, int r, int s, int e, int d) {
        arr[l] += s;
        arr[l + 1] += d - s;
        arr[r + 1] -= d + e;
        arr[r + 2] += e;
    }

    public static void build(int n) {
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
    }
}
