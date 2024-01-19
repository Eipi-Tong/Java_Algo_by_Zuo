package class11;

/**
 * ClassName: Algo_011_Two_Lists_Add
 * Package: class11
 * CreateTime: 2024/1/19 15:43
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_011_Two_Lists_Add {

    // 非负证书逆序串 相加
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

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        int carry = 0;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null || p2 != null) {
            int x1 = p1 == null ? 0 : p1.val;
            int x2 = p2 == null ? 0 : p2.val;
            int ans = carry + x1 + x2;

            carry = ans / 10;
            p.next = new ListNode(ans % 10);
            p = p.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers_v2(ListNode p1, ListNode p2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x1 = p1 == null ? 0 : p1.val;
            int x2 = p2 == null ? 0 : p2.val;
            int sum = carry + x1 + x2;

            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(sum % 10);
                cur = ans;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return ans;
    }
}
