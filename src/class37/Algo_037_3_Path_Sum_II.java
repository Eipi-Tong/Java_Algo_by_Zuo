package class37;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algo_037_3_Path_Sum_II
 * Package: class37
 * CreateTime: 2024/2/5 19:06
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/path-sum-ii/
public class Algo_037_3_Path_Sum_II {

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

    public List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, temp, 0, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> temp, int curSum, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (curSum + root.val == targetSum) {
                temp.add(root.val);
                ans.add(temp);
            }
            return;
        }
        temp.add(root.val);
        List<Integer> vec = new ArrayList<>(temp);
        dfs(root.left, temp, curSum + root.val, targetSum);
        dfs(root.right, vec, curSum + root.val, targetSum);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();
        process(root, 0, targetSum, ans, path);
        return ans;
    }

    public void process(TreeNode root, int cur, int aim, List<List<Integer>> ans, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (root.val + cur == aim) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            process(root.left, cur + root.val, aim, ans, path);
        }
        if (root.right != null) {
            process(root.right, cur + root.val, aim, ans, path);
        }
        path.remove(path.size() - 1);
    }
}
