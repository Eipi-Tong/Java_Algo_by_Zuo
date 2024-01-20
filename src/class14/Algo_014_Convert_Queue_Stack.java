package class14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: Algo_014_Convert_Queue_Stack
 * Package: class14
 * CreateTime: 2024/1/20 14:05
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */

// 均摊O(1)
public class Algo_014_Convert_Queue_Stack {

    public static class MyQueue {

        Stack<Integer> in, out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            moveInToOut();
            return out.pop();
        }

        public int peek() {
            moveInToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        public void moveInToOut() {
            if (out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.peek());
                    in.pop();
                }
            }
        }
    }

    public static class MyStack1 {

        Queue<Integer> in, out;

        public MyStack1() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void push(int x) {
            in.offer(x);
        }

        public int pop() {
            while (in.size() > 1) {
                out.offer(in.poll());

            }
            int x = in.poll();
            // swap in 和 out
            Queue<Integer> temp = in;
            in = out;
            out = temp;

            return x;
        }

        public int top() {
            while (in.size() > 1) {
                out.offer(in.poll());
            }
            int x = in.poll();
            out.offer(x);
            // swap in 和 out
            Queue<Integer> temp = in;
            in = out;
            out = temp;

            return x;
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    public static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
