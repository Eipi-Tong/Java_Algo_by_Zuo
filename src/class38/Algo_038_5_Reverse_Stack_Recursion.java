package class38;

import java.util.Stack;

/**
 * ClassName: Algo_038_5_Reverse_Stack_Recursion
 * Package: class38
 * CreateTime: 2024/2/8 15:05
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 时间复杂度：O(n^2)
public class Algo_038_5_Reverse_Stack_Recursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    /**
     * 栈底元素移除掉，上面的元素盖上来
     * 返回移除掉的栈底元素
     */
    public static int bottomOut(Stack<Integer> stack) {
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        int last = bottomOut(stack);
        stack.push(top);
        return last;
    }
}
