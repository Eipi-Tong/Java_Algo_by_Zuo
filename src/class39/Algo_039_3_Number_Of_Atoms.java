package class39;

import java.util.TreeMap;

/**
 * ClassName: Algo_039_3_Number_Of_Atoms
 * Package: class39
 * CreateTime: 2024/2/8 16:03
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/number-of-atoms/description/
public class Algo_039_3_Number_Of_Atoms {

    public static int where;

    // 需要按照字典序返回，因此使用有序表
    public static String countOfAtoms(String formula) {
        where = 0;
        TreeMap<String, Integer> treeMap = f(formula.toCharArray(), 0);
        StringBuilder ans = new StringBuilder();
        for (String key: treeMap.keySet()) {
            ans.append(key);
            int cnt = treeMap.get(key);
            if (cnt > 1) {
                ans.append(cnt);
            }
        }
        return ans.toString();
    }

    // s[i....]开始计算，遇到字符串终止 或者 遇到 ) 停止
    // 返回 : 自己负责的这一段字符串的结果，有序表！
    // 返回之间，更新全局变量where，为了上游函数知道从哪继续！
    public static TreeMap<String, Integer> f(char[] s, int i) {
        // ans是总表
        TreeMap<String, Integer> ans = new TreeMap<>();
        // 之前收集到的名字，历史一部分
        StringBuilder name = new StringBuilder();
        // 之前收集到的有序表，历史一部分
        TreeMap<String, Integer> pre = null;
        // 历史翻几倍
        int cnt = 0;
        while (i < s.length && s[i] != ')') {
            System.out.println(i);
            if (Character.isDigit(s[i])) {
                cnt = cnt * 10 + (s[i++] - '0');
            } else if (Character.isLowerCase(s[i])) {
                name.append(s[i++]);
            } else if (Character.isUpperCase(s[i]) || s[i] == '(') {
                // 遇到大写字母或者左括号 开始清算
                fill(ans, pre, name, cnt);
                name.setLength(0);
                pre = null;
                cnt = 0;
                if (Character.isUpperCase(s[i])) {
                    name.append(s[i++]);
                } else {
                    pre = f(s, i + 1);
                    i = where + 1;
                }
            }
        }
        fill(ans, pre, name, cnt);
        where = i;
        return ans;
    }

    public static void fill(TreeMap<String, Integer> ans, TreeMap<String, Integer> pre, StringBuilder name, int cnt) {
        if (name.length() == 0 && pre == null) {
            return;
        }
        cnt = cnt == 0 ? 1 : cnt;
        if (name.length() > 0) {
            String key = name.toString();
            ans.put(key, ans.getOrDefault(key, 0) + cnt);
        } else {
            for (String key: pre.keySet()) {
                ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);
            }
        }
    }
}
