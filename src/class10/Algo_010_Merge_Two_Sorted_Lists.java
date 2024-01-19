package class10;

/**
 * ClassName: Algo_010_Merge_Two_Sorted_Lists
 * Package: class10
 * CreateTime: 2024/1/19 15:17
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_010_Merge_Two_Sorted_Lists {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return (head1 == null) ? head2 : head1;
        }
        ListNode newHead = new ListNode(-1), p = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = (head1 != null) ? head1 : head2;
        return newHead.next;
    }
}
