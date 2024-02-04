package class36;

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
public class Algo_036_5_Pre_Serialize_Deserialize_Binary_Tree {

    /**
     * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化
     * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
     * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
     * 比如如下两棵树
     *              __2
     *             /
     *            1
     *            和
     *            1__
     *               \
     *                2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     */

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
        preOrderSerialize(root, builder);
        return builder.toString();
    }

    public void preOrderSerialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
        } else {
            builder.append(root.val + ",");
            preOrderSerialize(root.left, builder);
            preOrderSerialize(root.right, builder);
        }
    }

    public static int cnt;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        cnt = 0;
        return preOrderDeserialize(vals);
    }

    public TreeNode preOrderDeserialize(String[] data) {
        String cur = data[cnt++];
        if (cur.equals("#")) {
            return null;
        } else {
            TreeNode head = new TreeNode(Integer.valueOf(cur));
            head.left = preOrderDeserialize(data);
            head.right = preOrderDeserialize(data);
            return head;
        }
    }
}
