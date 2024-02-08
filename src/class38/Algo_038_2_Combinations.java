package class38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Algo_038_2_Combinations
 * Package: class38
 * CreateTime: 2024/2/7 21:23
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/subsets-ii/description/
// 时间复杂度：O(2^n * n)
public class Algo_038_2_Combinations {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
            return;
        }
        // 数下一个不同数字的位置
        int j = i + 1;
        while (j < nums.length && nums[i] == nums[j]) {
            j++;
        }
        f(nums, j, path, size, ans);
        while (i < j) {
            path[size++] = nums[i++];
            f(nums, j, path, size, ans);
        }
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            path.add(nums[i]);
            helper(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
