package class36;

import java.util.HashMap;

/**
 * ClassName: Algo_036_7_Construct_BT_Pre_Inorder
 * Package: class36
 * CreateTime: 2024/2/4 15:49
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class Algo_036_7_Construct_BT_Pre_Inorder {

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

    public class Pair {
        public int left;
        public int right;
        public Pair(int l, int r) {
            left = l;
            right = r;
        }
    }

    public TreeNode buildTree_Pre1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return preInBuild(preorder, inorder, new Pair(0, preorder.length - 1), new Pair(0, inorder.length - 1), hashMap);
    }

    public TreeNode preInBuild(int[] preorder, int[] inorder, Pair pre, Pair in, HashMap<Integer, Integer> map) {
        if (pre.left > pre.right) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[pre.left]);
        if (pre.left == pre.right) {
            return head;
        }
        int k = map.get(preorder[pre.left]);
        // pre.left == l1, pre.right == r1;
        // in.left == l2, in.right == r2;
        // pre : l1(........)[.......r1]
        // in  : (l2......)k[........r2]
        // (...)是左树对应，[...]是右树的对应
        head.left = preInBuild(preorder, inorder, new Pair(pre.left + 1, pre.left + k - in.left), new Pair(in.left, k - 1), map);
        head.right = preInBuild(preorder, inorder, new Pair(pre.left + 1 + k - in.left, pre.right), new Pair(k + 1, in.right), map);
        return head;
    }

    public static int preIndex;

    public TreeNode buildTree_Pre2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        preIndex = 0;
        return build2(preorder, hashMap, 0, inorder.length - 1);
    }

    public TreeNode build2(int[] pre, HashMap<Integer, Integer> map, int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preIndex++]);
        int k = map.get(pre[preIndex]);
        head.left = build2(pre, map, inL, k - 1);
        head.right = build2(pre, map, k + 1, inR);
        return head;
    }

    public static int postIndex;
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree_Post(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return postInBuild(postorder, 0, inorder.length - 1);
    }

    public TreeNode postInBuild(int[] postorder, int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postIndex]);
        int k = hashMap.get(postorder[postIndex]);
        postIndex--;
        cur.right = postInBuild(postorder, k + 1, inR);
        cur.left = postInBuild(postorder, inL, k - 1);
        return cur;
    }
}
