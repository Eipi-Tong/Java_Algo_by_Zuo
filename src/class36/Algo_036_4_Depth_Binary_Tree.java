package class36;

/**
 * ClassName: Algo_036_4_Depth_Binary_Tree
 * Package: class36
 * CreateTime: 2024/2/3 16:37
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class Algo_036_4_Depth_Binary_Tree {

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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left == null) {
            rightDepth = minDepth(root.right) + 1;
        }
        if (root.right == null) {
            leftDepth = minDepth(root.left) + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
