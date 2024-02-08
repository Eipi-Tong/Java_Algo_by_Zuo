package class38;

import java.util.HashSet;

/**
 * ClassName: Algo_038_1_Subsequences
 * Package: class38
 * CreateTime: 2024/2/6 20:59
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
// 时间复杂度：O(2^n * n)
public class Algo_038_1_Subsequences {

    // 生成所有子序列，但该题目要求去重
    public static String[] generatePermutation (String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f1(s, 0, new StringBuilder(), set);
        String[] ans = new String[set.size()];
        int i = 0;
        for (String cur: set) {
            ans[i++] = cur;
        }
        return ans;
    }

    // 当前s[i...] 之前已经决定的路径path
    public static void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
        if (i == s.length) {
            set.add(path.toString());
            return;
        }
        path.append(s[i]);   // 先加进去
        f1(s, i + 1, path, set);
        path.deleteCharAt(path.length() - 1);   // 然后删掉
        f1(s, i + 1, path, set);
    }

    public static String[] generatePermutation2 (String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f2(s, 0, new char[s.length], 0, set);
        String[] ans = new String[set.size()];
        int i = 0;
        for (String cur: set) {
            ans[i++] = cur;
        }
        return ans;
    }

    public static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
        if (i == s.length) {
            set.add(String.valueOf(path, 0, size));
            return;
        }
        path[size] = s[i];
        f2(s, i + 1, path, size + 1, set);
        f2(s, i + 1, path, size, set);
    }
}
