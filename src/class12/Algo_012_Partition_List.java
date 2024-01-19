package class12;

/**
 * ClassName: Algo_012_Partition_List
 * Package: class12
 * CreateTime: 2024/1/19 16:10
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_012_Partition_List {

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

    /**
     * 给你一个链表的头节点 head 和一个特定值 x
     * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置
     * 测试链接 : https://leetcode.cn/problems/partition-list/
     */
    public static ListNode partitionList(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        while (head != null) {
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = head.next;
        }
        if (rightHead != null) rightTail.next = null;  // 防止环
        if (leftHead == null) return rightHead; // 前面没有直接返回后面即可
        leftTail.next = rightHead; // 连接起来
        return leftHead;
    }
}
