package class36;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Algo_036_8_Check_Completeness_BT
 * Package: class36
 * CreateTime: 2024/2/4 15:52
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
public class Algo_036_8_Check_Completeness_BT {

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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            /**
             * 完全二叉树特征：（按照层次遍历）
             * 1）左子树空，右子树有值，一定为false
             * 2）只要子树有空，接下来遍历到的都是叶子结点，否则false
             */
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right != null || isLeaf && (cur.left != null || cur.right != null)) {
                return false;
            }
            if (cur.right == null) {
                isLeaf = true;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
