package class34;

/**
 * ClassName: Algo_034_2_Reverse_Nodes_kth_Group
 * Package: class34
 * CreateTime: 2024/2/1 14:25
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class Algo_034_2_Reverse_Nodes_kth_Group {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; this.next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode startNode = dummy;
        while (true) {
            int cnt = 0;
            ListNode front = startNode;
            while (front.next != null && cnt < k) {
                front = front.next;
                cnt++;
            }
            if (cnt != k) break;

            ListNode fnext = front.next;
            ListNode prev = fnext;
            ListNode cur = startNode.next;
            while (cur != fnext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode temp = startNode.next;
            startNode.next = front;
            startNode = temp;
        }
        return dummy.next;
    }
}
