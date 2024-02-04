package class35;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: Algo_035_2_LRU
 * Package: class35
 * CreateTime: 2024/2/1 20:14
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/lru-cache/description/
public class Algo_035_2_LRU {

    // 用双向链表和哈希表实现
    // 投越早，尾越晚
    public static class LRUCache {

        // 这里必须要自己实现双向队列
        public class DoubleNode {
            public int key;
            public int val;
            public DoubleNode prev;
            public DoubleNode next;

            public DoubleNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public class DoubleList {
            public DoubleNode head;
            public DoubleNode tail;

            public DoubleList() {
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode node) {
                if (node == null) {
                    return;
                }
                if (head == null) {
                    head = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                }
                tail = node;
            }

            public DoubleNode removeHead() {
                if (head == null) {
                    return null;
                }
                DoubleNode ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = ans.next;
                    ans.next = null;
                    head.prev = null;
                }
                return ans;
            }

            public void moveNodeToTail(DoubleNode node) {
                if (tail == node) {
                    return;
                }
                if (head == node) {
                    head = node.next;
                    head.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }
        }

        public int size;
        public DoubleList deque;
        public HashMap<Integer, DoubleNode> hashMap;

        public LRUCache(int capacity) {
            this.size = capacity;
            deque = new DoubleList();
            hashMap = new HashMap<>();
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                DoubleNode ans = hashMap.get(key);
                deque.moveNodeToTail(ans);
                return ans.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                DoubleNode node = hashMap.get(key);
                node.val = value;
                deque.moveNodeToTail(node);
            } else {
                if (hashMap.size() == size) {
                    hashMap.remove(deque.removeHead().key);
                }
                DoubleNode node = new DoubleNode(key, value);
                hashMap.put(key, node);
                deque.addNode(node);
            }
        }
    }
}
