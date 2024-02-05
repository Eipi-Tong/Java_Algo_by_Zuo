package class37;

/**
 * ClassName: Algo_037_2_Algo_037_1_Lowest_Common_Ancestor_BST
 * Package: class37
 * CreateTime: 2024/2/5 19:02
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class Algo_037_2_Algo_037_1_Lowest_Common_Ancestor_BST {

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
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else if (root.val == p.val) {
                return p;
            } else if (root.val == q.val) {
                return q;
            } else {
                // p.val < root.val < q.val
                return root;
            }
        }
        return null;
    }
}
