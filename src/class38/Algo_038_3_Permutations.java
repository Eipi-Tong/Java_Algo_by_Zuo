package class38;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algo_038_3_Permutations
 * Package: class38
 * CreateTime: 2024/2/7 22:02
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/permutations/description/
// 时间复杂度：O(n! * n)
public class Algo_038_3_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
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
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            helper(nums, i + 1, ans);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = permute(nums);
        for (List<Integer> list: ans) {
            for (int num: list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
