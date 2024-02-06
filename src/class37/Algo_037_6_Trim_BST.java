package class37;

/**
 * ClassName: Algo_037_6_Trim_BST
 * Package: class37
 * CreateTime: 2024/2/6 11:51
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/trim-a-binary-search-tree/
public class Algo_037_6_Trim_BST {

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

    public TreeNode head, prev;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        head = prev = null;
        dfs(root, low, high);
        return head;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        // System.out.println("val, low, high: " + root.val + " " + low + " " + high);
        // System.out.println(
        //         "head, prev: " + (head == null ? "null" : head.val) + " " + (prev == null ? "null" : prev.val));
        if (root.val < low) {
            if (prev != null) {
                prev.left = root.right;
            }
            dfs(root.right, low, high);
            return;
        }
        if (root.val > high) {
            if (prev != null) {
                prev.right = root.left;
            }
            dfs(root.left, low, high);
            return;
        }
        if (head == null) {
            head = root;
        }
        prev = root;
        dfs(root.left, low, high);
        prev = root; // 一定要清prev
        dfs(root.right, low, high);
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST2(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST2(root.left, low, high);
        }
        root.left = trimBST2(root.left, low, high);
        root.right = trimBST2(root.right, low, high);
        return root;
    }
}
