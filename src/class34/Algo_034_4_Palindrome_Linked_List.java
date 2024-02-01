package class34;

/**
 * ClassName: Algo_034_4_Palindrome_Linked_List
 * Package: class34
 * CreateTime: 2024/2/1 15:09
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/palindrome-linked-list/description/
public class Algo_034_4_Palindrome_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMid(head);
        reverseList(mid);   // 反转Mid结点后面的部分
        boolean ans = compareList(head, mid.next);
        reverseList(mid);   // 反转Mid结点后面的部分
        return ans;
    }

    public ListNode findMid(ListNode head) {
        /**
         * null         -> mid: null
         * 0 null       -> mid: 0
         * 0 1 null     -> mid: 0
         * 0 1 2 null   -> mid: 1
         * 0 1 2 3 null -> mid: 1
         */
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) slow = slow.next;
        }
        return slow;
    }

    public void reverseList(ListNode dummy) {
        ListNode prev = null;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        dummy.next = prev;
    }

    public boolean compareList(ListNode listA, ListNode listB) {
        while (listB != null) {
            if (listA.val != listB.val) {
                return false;
            }
            listA = listA.next;
            listB = listB.next;
        }
        return true;
    }
}
