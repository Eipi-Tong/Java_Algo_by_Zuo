package class36;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Algo_036_5_Serialize_Deserialize_Binary_Tree
 * Package: class36
 * CreateTime: 2024/2/3 16:58
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Algo_036_6_Level_Serialize_Deserialize_Binary_Tree {

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur == null ? "null" : cur.val);
            if (cur == null) {
                builder.append("#,");
            } else {
                builder.append(cur.val + ",");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals.length == 0 || vals[0].equals("#")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        queue.offer(root);
        int cnt = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = vals[cnt].equals("#") ? null : new TreeNode(Integer.valueOf(vals[cnt]));
            cnt++;
            cur.right = vals[cnt].equals("#") ? null : new TreeNode(Integer.valueOf(vals[cnt]));
            cnt++;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }


    public static final int MAXN = (int) 1e4 + 1;
    public static TreeNode[] queue = new TreeNode[MAXN];

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null)
            return builder.toString();
        int l = 0, r = 0;
        queue[r++] = root;
        builder.append(root.val + ",");
        while (l < r) {
            TreeNode cur = queue[l++];
            if (cur.left != null) {
                builder.append(cur.left.val + ",");
                queue[r++] = cur.left;
            } else {
                builder.append("#,");
            }
            if (cur.right != null) {
                builder.append(cur.right.val + ",");
                queue[r++] = cur.right;
            } else {
                builder.append("#,");
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data.equals("")) return null;
        String[] vals = data.split(",");
        if (vals.length == 0 || vals[0].equals("#")) {
            return null;
        }
        int l = 0, r = 0, cnt = 0;
        TreeNode root = new TreeNode(Integer.valueOf(vals[cnt++]));
        queue[r++] = root;
        while (l < r) {
            TreeNode cur = queue[l++];
            cur.left = vals[cnt].equals("#") ? null : new TreeNode(Integer.valueOf(vals[cnt]));
            cnt++;
            cur.right = vals[cnt].equals("#") ? null : new TreeNode(Integer.valueOf(vals[cnt]));
            cnt++;
            if (cur.left != null) {
                queue[r++] = cur.left;
            }
            if (cur.right != null) {
                queue[r++] = cur.right;
            }
        }
        return root;
    }
}
