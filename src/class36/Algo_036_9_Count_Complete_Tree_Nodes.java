package class36;

/**
 * ClassName: Algo_036_9_Count_Complete_Tree_Nodes
 * Package: class36
 * CreateTime: 2024/2/4 19:00
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/count-complete-tree-nodes/description/
public class Algo_036_9_Count_Complete_Tree_Nodes {

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

    // 求完全二叉树的结点个数，要求复杂度<O(n)
    // 复杂度是O(h^2) 也就是O((log n)^2)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = getDepth(root);
        int rightH = getDepth(root.right);
        if (height == rightH + 1) {
            return (int) Math.pow(2, rightH) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, rightH) + countNodes(root.left);
        }
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }


    // 提交如下的方法
    public static int countNodes2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return f(head, 1, mostLeft(head, 1));
    }

    // cur : 当前来到的节点
    // level :  当前来到的节点在第几层
    // h : 整棵树的高度，不是cur这棵子树的高度
    // 求 : cur这棵子树上有多少节点
    public static int f(TreeNode cur, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeft(cur.right, level + 1) == h) {
            // cur右树上的最左节点，扎到了最深层
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        } else {
            // cur右树上的最左节点，没扎到最深层
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    // 当前节点是cur，并且它在level层
    // 返回从cur开始不停往左，能扎到几层
    public static int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }
}
