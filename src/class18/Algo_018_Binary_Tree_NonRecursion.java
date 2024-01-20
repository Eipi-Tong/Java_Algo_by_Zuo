package class18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Algo_018_Binary_Tree_NonRecursion
 * Package: class18
 * CreateTime: 2024/1/20 16:54
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_018_Binary_Tree_NonRecursion {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 所有遍历方式（先、中、后序 递归和非递归）
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)  h表示树的高度
     * 存在时间复杂度O(n)，空间复杂度O(1)的算法：Morris遍历
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        head.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        System.out.println("先序遍历-非递归");
        preOrder(head);
        System.out.println();

        System.out.println("中序遍历-非递归");
        inOrder(head);
        System.out.println();

        System.out.println("后序遍历-非递归 两个stack");
        postOrder1(head);
        System.out.println();

        System.out.println("后序遍历-非递归  一个stack");
        postOrder2(head);
        System.out.println();
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (head != null) {
            stack.push(head);
            head = head.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
    }

    public static void postOrder1(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> collect = new Stack<TreeNode>();
        stack.push(head);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            collect.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!collect.isEmpty()) {
            System.out.print(collect.pop().val + " ");
        }
    }

    public static void postOrder2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        // head 最初表示头节点；第一次表示打印结点；之后表示前一次结点；
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && head != node.left && head != node.right) {
                // 有左树，且左树没有处理过
                stack.push(node.left);
            } else if (node.right != null && head != node.right) {
                // 有右树，且右树没有处理过
                stack.push(node.right);
            } else {
                System.out.print(node.val + " ");
                head = stack.pop();
            }
        }
    }

    // leetcode题目
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return ans;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
                root = node.right;
            }
        }
        return ans;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // head 最初表示头节点；第一次表示打印结点；之后表示前一次结点；
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && root != node.left && root != node.right) {
                // 有左树，且左树没有处理过
                stack.push(node.left);
            } else if (node.right != null && root != node.right) {
                // 有右树，且右树没有处理过
                stack.push(node.right);
            } else {
                ans.add(node.val);
                root = stack.pop();
            }
        }
        return ans;
    }
}
