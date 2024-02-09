package class39;

import java.util.ArrayList;

/**
 * ClassName: Algo_039_1_Basic_Calculator_III
 * Package: class39
 * CreateTime: 2024/2/8 15:58
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/basic-calculator-iii/description/
public class Algo_039_1_Basic_Calculator_III {
    // 实现表达式的字符串 求解其数字结果
    // 不用考虑溢出和表达式错误的问题

    // 知道返回的上游函数的位置
    public static int where;

    public static int calculate(String str) {
        where = 0;
        return f(str.toCharArray(), 0);
    }

    public static int f(char[] s, int i) {
        int cur = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        while (i < s.length && s[i] != ')') {
            if (Character.isDigit(s[i])) {
                cur = cur * 10 + (s[i++] - '0');
            } else if (s[i] != '(') {
                push(nums, ops, cur, s[i++]);
                cur = 0;
            } else {
                // s[i] == '('
                cur = f(s, i + 1);
                i = where + 1;

            }
        }
        push(nums, ops, cur, '+');
        where = i;
        int ans = nums.get(0); // 数字栈一定有值
        for (int j = 1; j < nums.size(); j++) {  // 此时栈中只有加减法
            ans += ops.get(j - 1) == '+' ? nums.get(j) : -nums.get(j);
        }
        return ans;
    }

    public static void push(ArrayList<Integer> nums, ArrayList<Character> ops, int cur, char op) {
        int n = nums.size();
        if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
            nums.add(cur);
            ops.add(op);
        } else {
            int topNum = nums.get(n - 1);
            char topOp = ops.get(n - 1);
            if (topOp == '*') {
                nums.set(n - 1, topNum * cur);
            } else {
                nums.set(n - 1, topNum / cur);
            }
            ops.set(n - 1, op);
        }
    }

    public static void main(String[] args) {
        // test字符串不能有空格
        String test = "36-(4*(3+2*(1-6))+5/5)+17";
        System.out.println("Ans is: " + calculate(test));
    }
}
