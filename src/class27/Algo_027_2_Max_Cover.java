package class27;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName: Algo_027_2_Max_Cover
 * Package: class27
 * CreateTime: 2024/1/26 17:14
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
public class Algo_027_2_Max_Cover {

    public static final int MAXN = (int)1e5+1;
    public static int[][] line = new int[MAXN][2];
    public static int[] heap = new int[MAXN];
    public static int n;      // pairs number
    public static int size;   // heap size

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
        size = 0;  // 最初堆大小是0
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = line[i][0], over = line[i][1];
            while (size != 0 && heap[0] <= start) {
                swap(0, --size);
                heapify(0);
            }
            heapInsert(over);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    public static void heapInsert(int x) {
        int i = size++;  // 插入位置是i
        heap[i] = x;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int i) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = (l + 1 < size) && (heap[l + 1] < heap[l]) ? l + 1 : l;
            if (heap[i] <= heap[best]) break;
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
