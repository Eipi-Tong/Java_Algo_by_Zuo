package class27;

import java.util.PriorityQueue;

/**
 * ClassName: Algo_027_Merge_Kth_Sorted_Lists
 * Package: class27
 * CreateTime: 2024/1/26 16:06
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_027_1_Merge_Kth_Sorted_Lists {

    public static class ListNode {
        public static int val;
        public static ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 列表k条 总结点数N, 时间复杂度：N*logK，空间复杂度：O(k)
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode h: lists) {
            if (h != null) {
                heap.add(h);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode prev = head;
        if (prev.next != null) {
            heap.add(prev.next);
        }
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            prev.next = curr;
            prev = curr;
            if (curr.next != null) {
                heap.add(curr.next);
            }
        }
        return head;
    }
}
