package class34;

/**
 * ClassName: Algo_034_1_Intersection_Two_Linked_Lists
 * Package: class34
 * CreateTime: 2024/2/1 14:13
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Algo_034_1_Intersection_Two_Linked_Lists {

    public static class ListNode {
        public static int val;
        public static ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}
