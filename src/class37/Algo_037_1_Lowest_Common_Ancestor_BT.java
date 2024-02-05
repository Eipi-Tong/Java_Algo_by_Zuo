package class37;

import class36.Algo_036_1_Binary_Tree_Level_Order;

/**
 * ClassName: Algo_037_1_Lowest_Common_Ancestor_BT
 * Package: class37
 * CreateTime: 2024/2/5 17:34
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class Algo_037_1_Lowest_Common_Ancestor_BT {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root; // 遇到空或者p或者q，直接返回
        }
        // 左树搜索，右树搜索
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        }
        if (l != null && r != null) {
            return root;
        }
        return l == null ? r : l;
    }
}
