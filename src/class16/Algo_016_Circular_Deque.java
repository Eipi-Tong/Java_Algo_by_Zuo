package class16;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Algo_016_Circular_Deque
 * Package: class16
 * CreateTime: 2024/1/20 15:33
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_016_Circular_Deque {

    public static class MyCircularDeque1 {

        public Deque<Integer> deque = new LinkedList<>();
        public int size, limit;

        public MyCircularDeque1(int k) {
            limit = k;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerFirst(value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            deque.pollFirst();
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            deque.pollLast();
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : deque.peekFirst();
        }

        public int getRear() {
            return isEmpty() ? -1 : deque.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    public static class MyCircularDeque2 {

        public int[] deque;
        public int l, r, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            limit = k;
            l = r = size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            l = (l == 0) ? limit - 1 : l - 1;
            deque[l] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque[r] = value;
            r = (r == limit - 1) ? 0 : r + 1;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l = (l == limit - 1) ? 0 : l + 1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            r = (r == 0) ? limit - 1 : r - 1;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : deque[l];
        }

        public int getRear() {
            int last = r == 0 ? limit - 1 : r - 1;
            return isEmpty() ? -1 : deque[last];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
