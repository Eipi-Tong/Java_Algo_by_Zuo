package class17;

/**
 * ClassName: Algo_017_Binary_Tree_Recursion
 * Package: class17
 * CreateTime: 2024/1/20 16:04
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_017_Binary_Tree_Recursion {

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

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        head.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        System.out.println("先序遍历");
        preOrder(head);
        System.out.println();

        System.out.println("中序遍历");
        inOrder(head);
        System.out.println();

        System.out.println("后序遍历");
        postOrder(head);
        System.out.println();
    }

    /**
     * 每个非null结点一定会来到3次，如图1，2，3
     * 递归序：
     * 1，2，4，4，4，2，5，5，5，2，
     * 1，3，6，6，6，3，7，7，7，3，
     * 1，
     * 先序： 输出 第一次 来到的
     * 中序： 输出 第二次 来到的
     * 后序： 输出 第三次 来到的
     *
     * @param head
     */
    public static void f(TreeNode head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }

    public static void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + " ");
    }
}
