package class34;

/**
 * ClassName: Algo_034_6_Sort_List
 * Package: class34
 * CreateTime: 2024/2/1 15:29
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/sort-list/description/
public class Algo_034_6_Sort_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode startNd, endNd;

    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        for (int k = 1; k < n; k <<= 1) {
            ListNode startNode = head;
            boolean isFirst = true;
            ListNode preEnd = endNd;
            while (startNode != null) {
                ListNode leftHead = startNode;
                ListNode leftTail = findEnd(startNode, k);
                ListNode rightHead = leftTail == null ? null : leftTail.next;
                ListNode rightTail = findEnd(rightHead, k);

                startNode = rightTail == null ? null : rightTail.next;
                if (leftTail != null) leftTail.next = null;
                if (rightTail != null) rightTail.next = null;
                mergeLists(leftHead, leftTail, rightHead, rightTail);
                if (isFirst) {
                    head = startNd;
                    endNd.next = startNode;
                    isFirst = false;
                } else {
                    preEnd.next = startNd;
                    endNd.next = startNode;
                }
                preEnd = endNd;
            }
        }
        return head;
    }

    public ListNode findEnd(ListNode start, int k) {
        if (start == null)
            return null;
        while (start.next != null && --k != 0) {
            start = start.next;
        }
        return start;
    }

    public void mergeLists(ListNode lH, ListNode lT, ListNode rH, ListNode rT) {
        startNd = lH;
        endNd = lT;
        if (rH == null)
            return;
        ListNode pa = lH, pb = rH;
        if (pa.val <= pb.val) {
            startNd = pa;
            pa = pa.next;
        } else {
            startNd = pb;
            pb = pb.next;
        }
        ListNode p = startNd;
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                p.next = pa;
                pa = pa.next;
            } else {
                p.next = pb;
                pb = pb.next;
            }
            p = p.next;
        }
        if (pa != null) {
            p.next = pa;
            endNd = lT;
        } else {
            p.next = pb;
            endNd = rT;
        }
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList2(left), sortList2(right));
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
