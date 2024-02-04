package class36;

import java.util.*;

/**
 * ClassName: Algo_036_3_Max_Width_Binary_Tree
 * Package: class36
 * CreateTime: 2024/2/3 15:20
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class Algo_036_3_Max_Width_Binary_Tree {

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

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> treeHash = new HashMap<>();
        queue.offer(root);
        treeHash.put(root, 0);
        int ans = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int minn = -1, maxn = -1;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    treeHash.put(cur.left, treeHash.get(cur) * 2);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    treeHash.put(cur.right, treeHash.get(cur) * 2 + 1);
                }
                if (i == 0) {
                    minn = treeHash.get(cur);
                }
                if (i == n - 1) {
                    maxn = treeHash.get(cur);
                }
            }
            ans = Math.max(ans, maxn - minn);
        }
        return ans;
    }

    public class Pair {
        public TreeNode node;
        public int num;
        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) return -1;
        int ans = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int n = queue.size();
            int first = -1, last = -1;
            for (int i = 0; i < n; i++) {
                Pair cur = queue.poll();
                if (i == 0) {
                    first = cur.num;
                }
                if (i == n - 1) {
                    last = cur.num;
                }
                if (cur.node.left != null) {
                    queue.offer(new Pair(cur.node.left, cur.num * 2));
                }
                if (cur.node.right != null) {
                    queue.offer(new Pair(cur.node.right, cur.num * 2 + 1));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public int widthOfBinaryTree3(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, 0, new ArrayList<>());
    }

    public int dfs(TreeNode root, int depth, int index, List<Integer> list) {
        if (root == null) return 0;
        if (depth == list.size()) {
            list.add(index);  // 每一层最前面的那个结点的index
        }
        int curWidth = index - list.get(depth) + 1;
        // 左边、右边子树中遍历下来得到的最大的结果
        int left = dfs(root.left, depth + 1, index * 2, list);
        int right = dfs(root.right, depth + 1, index * 2 + 1, list);
        return Math.max(curWidth, Math.max(left, right));
    }
}
