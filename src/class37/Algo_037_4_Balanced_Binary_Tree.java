package class37;

/**
 * ClassName: Algo_037_4_Balanced_Binary_Tree
 * Package: class37
 * CreateTime: 2024/2/5 22:18
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/balanced-binary-tree/description/
public class Algo_037_4_Balanced_Binary_Tree {

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

    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static boolean balance;

    public boolean isBalanced2(TreeNode root) {
        balance = true;
        height(root);
        return balance;
    }

    public int height(TreeNode root) {
        if (!balance || root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1) {
            balance = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
