package class36;

import java.util.*;

/**
 * ClassName: Algo_036_2_Binary_Tree_Zigzag_Level_Order
 * Package: class36
 * CreateTime: 2024/2/3 14:53
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Algo_036_2_Binary_Tree_Zigzag_Level_Order {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean leftToright = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> list = new ArrayList<>();
            while (n-- != 0) {
                if (leftToright) {
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if (cur.left != null) deque.offerLast(cur.left);
                    if (cur.right != null) deque.offerLast(cur.right);
                } else {
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if (cur.right != null) deque.offerFirst(cur.right);
                    if (cur.left != null) deque.offerFirst(cur.left);
                }
            }
            ans.add(list);
            leftToright = !leftToright;
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean leftToright = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while (n-- != 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (leftToright) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
            }
            ans.add(list);
            leftToright = !leftToright;
        }
        return ans;
    }
}
