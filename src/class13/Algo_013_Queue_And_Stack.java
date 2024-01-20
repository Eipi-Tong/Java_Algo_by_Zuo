package class13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: Algo_013_Queue_And_Stack
 * Package: class13
 * CreateTime: 2024/1/20 11:49
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_013_Queue_And_Stack {

    public static class Queue1 {

        // java 中的双向链表
        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // 向队列中加入一个数
        public void offer(int num) {
            queue.offer(num);
        }

        // 从队列拿出
        public int poll() {
            return queue.poll();
        }

        // 返回队列头元素，但是不弹出
        public int peek() {
            return queue.peek();
        }

        // 返回队列大小
        public int size() {
            return queue.size();
        }
    }

    // 数组实现队列
    public static class Queue2 {
        public int[] queue;
        public int l;
        public int r;

        public Queue2(int n) {
            queue = new int[n];
            l = 0;
            r = 0;
        }

        public boolean isEmpty() {
            return l == r;
        }

        // ++在后面 表示先计算叔，然后再完成++操作
        // 向队列中加入一个数
        public void offer(int num) {
            queue[r++] = num;
        }

        // 从队列拿出
        public int poll() {
            return queue[l++];
        }

        // 返回队列头元素，但是不弹出
        public int head() {
            return queue[l];
        }

        public int tail() {
            if (r < 1) return -1;  // 出错判断
            return queue[r - 1];
        }

        // 返回队列大小
        public int size() {
            return r - l;
        }
    }

    public static class Stack1 {

        public Stack<Integer> stack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void push(int num) {
            stack.push(num);
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public int size() {
            return stack.size();
        }
    }

    public static class Stack2 {
        public int[] stack;
        public int size;

        public Stack2(int n) {
            stack = new int[n];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int num) {
            stack[size++] = num;
        }

        public int pop() {
            if (size < 1) return -1; // 出错判断
            return stack[--size];
        }

        public int peek() {
            return stack[size - 1];
        }

        public int size() {
            return size;
        }
    }

    public static class MyCircularQueue {
        public int[] queue;
        public int l, r;
        public int size;   // 队列大小
        public int limit;  // 数组大小

        // 数组大小为k
        public MyCircularQueue(int k) {
            queue = new int[k];
            limit = k;
            l = r = size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[r] = value;
            r = (r == limit - 1) ? 0 : (r + 1);
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            l = (l == limit - 1) ? 0 : (l + 1);
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int last = (r == 0) ? (limit - 1) : (r - 1);
            return queue[last];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
