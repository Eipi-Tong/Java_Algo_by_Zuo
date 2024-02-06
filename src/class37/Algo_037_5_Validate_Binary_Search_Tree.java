package class37;

import java.util.Stack;

/**
 * ClassName: Algo_037_5_Validate_Binary_Search_Tree
 * Package: class37
 * CreateTime: 2024/2/5 22:22
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/validate-binary-search-tree/description/
public class Algo_037_5_Validate_Binary_Search_Tree {

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

    // 中序遍历升序 一定是BST
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        boolean first = true;
        int prev = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (!first && cur.val <= prev) {
                return false;
            }
            prev = cur.val;
            first = false;
            TreeNode x = cur.right;
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }
        return true;
    }

    public static final int MAXN = (int) 1e5+1;
    public static TreeNode[] stack = new TreeNode[MAXN];

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int r = 0;
        TreeNode prev = null;
        while (r > 0 || root != null) {
            if (root != null) {
                stack[r++] = root;
                root = root.left;
            } else {
                root = stack[--r];
                if (prev != null && prev.val >= root.val) {
                    return false;
                }
                prev = root;
                root = root.right;
            }
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long start, long end) {
        if (root == null) {
            return true;
        }
        if (root.val <= start || root.val >= end) {
            return false;
        }
        return helper(root.left, start, (long) root.val) && helper(root.right, (long) root.val, end);
    }
}
