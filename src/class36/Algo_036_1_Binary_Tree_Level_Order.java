package class36;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Algo_036_1_Binary_Tree_Level_Order
 * Package: class36
 * CreateTime: 2024/2/3 14:51
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class Algo_036_1_Binary_Tree_Level_Order {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            while (n-- != 0) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        pre(root, 0, ans);
        return ans;
    }

    public void pre(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
        } else {
            ans.get(level).add(root.val);
        }
        pre(root.left, level + 1, ans);
        pre(root.right, level + 1, ans);
    }

    public final int MAXN = 2001;
    public TreeNode[] queue = new TreeNode[MAXN];

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int l = 0, r = 0;
        if (root != null) {
            queue[r++] = root;
        }
        while (l < r) {
            int n = r - l;
            List<Integer> list = new ArrayList<>();
            while (n-- != 0) {
                TreeNode cur = queue[l++];
                list.add(cur.val);
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
