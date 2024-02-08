package class39;

import java.util.Stack;

/**
 * ClassName: Algo_039_0_Basic_Calculator_II
 * Package: class39
 * CreateTime: 2024/2/8 16:33
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/basic-calculator-ii/description/
public class Algo_039_0_Basic_Calculator_II {

    // 使用stack
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOperator(c) || i == s.length() - 1) {
                if (operator == '+') stack.push(num);
                else if (operator == '-') stack.push(-num);
                else if (operator == '*') stack.push(stack.pop() * num);
                else if (operator == '/') stack.push(stack.pop() / num);

                num = 0;
                operator = c;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int calculate2(String s) {
        int num = 0;
        char operator = '+';
        int last = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOperator(c) || i == s.length() - 1) {
                if (operator == '+') {
                    sum += last;
                    last = num;
                }
                else if (operator == '-') {
                    sum += last;
                    last = -num;
                }
                else if (operator == '*') {
                    last *= num;
                }
                else if (operator == '/') {
                    last /= num;
                }

                num = 0;
                operator = c;
            }
        }
        return sum + last;
    }
}
