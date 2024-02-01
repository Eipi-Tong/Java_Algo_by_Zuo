package class34;

import java.util.HashMap;

/**
 * ClassName: Algo_034_3_Copy_List_With_Random
 * Package: class34
 * CreateTime: 2024/2/1 14:56
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class Algo_034_3_Copy_List_With_Random {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node newNode = hashMap.get(cur);
            newNode.next = hashMap.get(cur.next);
            newNode.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    public Node copyRandomList_NoHash(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = cur.next;
        while (cur != null) {
            Node next = cur.next.next;
            cur.next.next = next == null ? null : next.next;
            cur.next = next;
            cur = cur.next;
        }
        return newHead;
    }
}
