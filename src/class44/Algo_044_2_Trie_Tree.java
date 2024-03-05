package class44;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName: Algo_044_2_Trie_Tree
 * Package: class44
 * CreateTime: 2024/3/5 16:41
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://www.nowcoder.com/practice/7f8a8553ddbf4eaab749ec988726702b
public class Algo_044_2_Trie_Tree {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = in.readLine()) != null) {
            build();
            int m = Integer.valueOf(line);
            for (int i = 0; i < m; i++) {
                String[] splits = in.readLine().split(" ");
                int op = Integer.valueOf(splits[0]);
                if (op == 1) {
                    insert(splits[1]);
                } else if (op == 2) {
                    delete(splits[1]);
                } else if (op == 3) {
                    out.println(search(splits[1]) > 0 ? "YES" : "NO");
                } else if (op == 4) {
                    out.println(preflixNumber(splits[1]));
                }
            }
            clear();
        }
        out.flush();
        in.close();
        out.close();
    }

    public static final int MAXN = 150001;
    public static final int ALPHA = 26;
    public static int[][] tree = new int[MAXN][ALPHA];
    public static int[] end = new int[MAXN];
    public static int[] pass = new int[MAXN];
    public static int cnt;

    public static void build() {
        cnt = 1;
    }

    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            end[i] = 0;
            pass[i] = 0;
        }
    }

    public static void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            if (tree[cur][x] == 0) {
                tree[cur][x] = ++cnt;
            }
            cur = tree[cur][x];
            pass[cur]++;
        }
        end[cur]++;
    }

    public static void delete(String word) {
        if (search(word) > 0) {
            int cur = 1;
            pass[cur]--;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (--pass[tree[cur][x]] == 0) {
                    tree[cur][x] = 0;
                    return;
                }
                cur = tree[cur][x];
            }
            end[cur]--;
        }
    }

    public static int search(String word) {
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return end[cur];
    }

    public static int preflixNumber(String preflix) {
        int cur = 1;
        for (int i = 0, path; i < preflix.length(); i++) {
            path = preflix.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }
}
