package class27;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName: Algo_027_2_Max_Cover_PQ
 * Package: class27
 * CreateTime: 2024/1/27 11:13
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_027_2_Max_Cover_PQ {

    public static final int MAXN = (int)1e5+1;
    public static int[][] line = new int[MAXN][2];
    public static int n;      // pairs number

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    in.nextToken();
                    line[i][j] = (int)in.nval;
                }
            }
            out.println(maxCover());
        }
        out.flush();
        out.close();
    }

    public static int maxCover() {
        Arrays.sort(line, 0, n, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = line[i][0], over = line[i][1];
            while (heap.size() > 0 && heap.peek() <= start) {
                heap.poll();
            }
            heap.add(over);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
