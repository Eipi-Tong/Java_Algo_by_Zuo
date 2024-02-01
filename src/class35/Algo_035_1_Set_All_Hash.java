package class35;

import java.io.*;
import java.util.HashMap;

/**
 * ClassName: Algo_035_1_Set_All_Hash
 * Package: class35
 * CreateTime: 2024/2/1 19:50
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
public class Algo_035_1_Set_All_Hash {

    public static int cnt;   // 时间计数器
    public static int setAllValue;   // setAll的值
    public static int setAllTime;    // setAll的时间
    public static HashMap<Integer, int[]> map = new HashMap<>();  // 数组始终包含两个数，前者表示值，后者表示时间

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            init();
            int n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                int op = (int) in.nval;
                if (op == 1) {
                    in.nextToken();
                    int x = (int) in.nval;
                    in.nextToken();
                    int y = (int) in.nval;
                    put(x, y);
                } else if (op == 2) {
                    in.nextToken();
                    int x = (int) in.nval;
                    out.println(get(x));
                } else {
                    in.nextToken();
                    int x = (int) in.nval;
                    setAll(x);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void init() {
        cnt = 0;
        setAllValue = 0;
        setAllTime = -1;
        map.clear();
    }

    public static void put(int key, int val) {
        if (map.containsKey(key)) {
            int[] value = map.get(key);
            value[0] = val;
            value[1] = cnt++;
        } else {
            map.put(key, new int[] {val, cnt++});
        }
    }

    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int[] value = map.get(key);
        // 比较setAllTime和之前put的时间哪个更新
        if (value[1] > setAllTime) {
            return value[0];
        } else {
            return setAllValue;
        }
    }

    public static void setAll(int val) {
        setAllValue = val;
        setAllTime = cnt++;
    }
}
