package class100;

import java.util.ArrayList;

/**
 * ClassName: Algo_100_2_Subtree_Of_Another_Tree
 * Package: class100
 * CreateTime: 2024/3/23 19:50
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/subtree-of-another-tree/description/
public class Algo_100_2_Subtree_Of_Another_Tree {

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

    // 方法一：暴力递归 O(n * m)
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            return same(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
        }
        return t2 == null;
    }

    // 判断两树是否相同
    public boolean same (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null) {
            return t1.val == t2.val && same(t1.left, t2.left) && same(t1.right, t2.right);
        }
        return false;
    }

    // 方法二：先序序列化后进行KMP
    public boolean isSubtree2(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null) {
            ArrayList<String> s1 = new ArrayList<>();
            ArrayList<String> s2 = new ArrayList<>();
            serial(t1, s1);
            serial(t2, s2);
            return kmp(s1, s2) != -1;
        }
        return t2 == null;
    }

    public void serial(TreeNode root, ArrayList<String> path) {
        if (root == null) {
            path.add("null");
        } else {
            path.add(String.valueOf(root.val));
            serial(root.left, path);
            serial(root.right, path);
        }
    }

    public int kmp(ArrayList<String> s1, ArrayList<String> s2) {
        int n = s1.size(), m = s2.size();
        int x = 0, y = 0;
        int[] next = getNext(s2, m);
        while (x < n && y < m) {
            if (s1.get(x).equals(s2.get(y))) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == m ? x - m : -1;
    }

    public int[] getNext(ArrayList<String> s2, int m) {
        if (m == 1) {
            return new int[] {-1};
        }
        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;
        int i = 2, cn = 0;
        while (i < m) {
            if (s2.get(i - 1).equals(s2.get(cn))) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
