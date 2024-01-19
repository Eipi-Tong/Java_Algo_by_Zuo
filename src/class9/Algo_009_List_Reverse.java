package class9;

/**
 * ClassName: Algo_009_List_Reverse
 * Package: class9
 * CreateTime: 2024/1/19 14:21
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_009_List_Reverse {

    public static void main (String[] args) {
        // 基本类型 + String都是按值传递的
        int a = 10;
        f(10);
        System.out.println(a);

        // 下面是按照引用类型传递的
        Number b = new Number(5);
        g1(b);
        System.out.println(b.val);
        g2(b);
        System.out.println(b.val);

        // 对于一维数组
        int[] c = {1, 2, 3, 4};
        g3(c);
        System.out.println(c[0]);
        g4(c);
        System.out.println(c[0]);
    }

    public static class Number {
        public int val;

        public Number(int v) {
            val = v;
        }
    }

    public static void f (int a) {
        a = 10;
    }

    public static void g1 (Number b) {
        b = null;
    }

    public static void g2 (Number b) {
        b.val = 6;
    }

    public static void g3 (int[] c) {
        c = null;
    }

    public static void g4 (int[] c) {
        c[0] = 100;
    }

    // 单链表Node
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode (int val) {
            this.val = val;
        }

        public ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class DoubleListNode {
        public int val;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }

    // 反转单链表
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }
        return newHead.next;
    }

    // 反转双链表
    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode prev = null;
        while (head != null) {
            DoubleListNode next = head.next;
            head.next = prev;
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;
    }
}
