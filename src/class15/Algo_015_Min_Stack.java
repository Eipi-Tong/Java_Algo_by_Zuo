package class15;

import java.util.Stack;

/**
 * ClassName: Algo_015_Min_Stack
 * Package: class15
 * CreateTime: 2024/1/20 15:03
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_015_Min_Stack {

    public static class MinStack1 {

        Stack<Integer> stack, minStk;

        public MinStack1() {
            stack = new Stack<Integer>();
            minStk = new Stack<Integer>();
        }

        public void push(int val) {
            stack.push(val);
            int x = minStk.isEmpty() ? val : Math.min(minStk.peek(), val);
            minStk.push(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStk.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStk.peek();
        }
    }

    // 没有完成一些必要的错误判断
    public static class MinStack2 {

        public int[] stack, minStk;
        public int size;
        public static final int N = 8001;  // 根据leetcode数据范围设置

        public MinStack2() {
            stack = new int[N];
            minStk = new int[N];
            size = 0;
        }

        public void push(int val) {
            stack[size] = val;
            int x = (size == 0) ? val : Math.min(minStk[size - 1], val);
            minStk[size] = x;
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return stack[size - 1];
        }

        public int getMin() {
            return minStk[size - 1];
        }
    }
}
