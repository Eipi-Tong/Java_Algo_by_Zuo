package class37;

/**
 * ClassName: Algo_037_7_House_Robber
 * Package: class37
 * CreateTime: 2024/2/6 11:52
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/house-robber-iii/description/
public class Algo_037_7_House_Robber_III {

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

    public int rob2(TreeNode root) {
        // 纯递归 会超时的!!!!
        int ans1 = helper(root, true);
        int ans2 = helper(root, false);
        return Math.max(ans1, ans2);
    }

    public int helper(TreeNode root, boolean rob) {
        if (root == null) {
            return 0;
        }
        // 为什么会超时？因为true和false会去分别遍历一遍，其实遍历一遍即可
        if (rob) {
            return helper(root.left, false) + helper(root.right, false) + root.val;
        } else {
            return Math.max(helper(root.left, true), helper(root.left, false))
                    + Math.max(helper(root.right, true), helper(root.right, false));
        }
    }

    // 全局变量，完成了X子树的遍历，返回之后
    // yes变成，X子树在偷头节点的情况下，最大的收益
    public static int yes;
    // 全局变量，完成了X子树的遍历，返回之后
    // no变成，X子树在不偷头节点的情况下，最大的收益
    public static int no;

    public int rob(TreeNode root) {
        f(root);
        return Math.max(yes, no);
    }

    public void f(TreeNode root) {
        if (root == null) {
            yes = 0;
            no = 0;
            return;
        }
        // y, n 表示暂存的 root结点的yes和no
        int y = root.val;
        int n = 0;

        f(root.left);
        y += no;
        n += Math.max(yes, no);
        f(root.right);
        y += no;
        n += Math.max(yes, no);

        yes = y;
        no = n;
    }
}
