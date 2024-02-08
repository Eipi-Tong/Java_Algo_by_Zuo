package class38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName: Algo_038_4_Permutations_Without_Recursion
 * Package: class38
 * CreateTime: 2024/2/8 14:54
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/permutations-ii/description/
// 时间复杂度：O(n! * n)
public class Algo_038_4_Permutations_Without_Recursion {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }

    public static void helper(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num: nums) {
                cur.add(num);
            }
            ans.add(cur);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            // nums[j]没有来到过i位置，才会去尝试
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                swap(nums, i, j);
                helper(nums, i + 1, ans);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
