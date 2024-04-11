package class47;

import java.io.*;

/**
 * ClassName: Algo_047_3_Water_Height
 * Package: class47
 * CreateTime: 2024/4/11 10:59
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_047_3_Water_Height {

    public static final int MAXN = (int) 1e6+5;
    public static final int OFFSET = 30001;
    public static int[] arr = new int[OFFSET + MAXN + OFFSET];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken(); int v = (int) in.nval;
                in.nextToken(); int x = (int) in.nval;
                fall(v, x);
            }
            build(m);

            int start = OFFSET + 1;
            for (int i = 1; i <= m; i++) {
                out.print(arr[start++] + " ");
            }
            out.println();
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void fall(int v, int x) {
        set(x - 3 * v + 1, x - 2 * v, 1, v, 1);
        set(x - 2 * v + 1, x, v - 1, -v, -1);
        set(x + 1, x + 2 * v, - v + 1, v, 1);
        set(x + 2 * v + 1, x + 3 * v - 1, v - 1, 1, -1);
    }

    public static void set(int l, int r, int s, int e, int d) {
        arr[l + OFFSET] += s;
        arr[l + 1 + OFFSET] += d - s;
        arr[r + 1 + OFFSET] -= d + e;
        arr[r + 2 + OFFSET] += e;
    }

    public static void build(int m) {
        for (int i = 1; i <= m + OFFSET; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= m + OFFSET; i++) {
            arr[i] += arr[i - 1];
        }
    }
}
