package class39;

import java.util.Stack;

/**
 * ClassName: Algo_039_0_Basic_Calculator
 * Package: class39
 * CreateTime: 2024/2/8 22:46
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/basic-calculator/description/
public class Algo_039_0_Basic_Calculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(res);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();    //stack.pop() is the sign before the parenthesis
                res += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }
}
