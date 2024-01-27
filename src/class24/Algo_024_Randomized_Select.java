package class24;

/**
 * ClassName: Algo_024_Randomized_Sort
 * Package: class24
 * CreateTime: 2024/1/25 16:47
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */

/**
 * 求无序数组中第k大或者第k小的数
 * 要求时间复杂度O(n)，额外空间复杂度O(1)
 * 算法导论9.2 证明其复杂度
 * 补充 BFPRT算法
 */
public class Algo_024_Randomized_Select {

    public static int findKthLargest(int[] nums, int k) {
//        return findKthLargest(nums, 0, nums.length - 1, nums.length - k); // 注意是第k大的数
        return randomizedSelect(nums, nums.length - k);
    }

    // 我使用的递归实现方式
    public static int findKthLargest(int[] nums, int l, int r, int k) {
        int x = nums[l + (int)(Math.random() * (r - l + 1))];
        partition(nums, l, r, x);
        int left = first, right = last;
        if (k >= left && k <= right) {
            return x;
        } else if (k < left) {
            return findKthLargest(nums, l, left - 1, k);
        } else {
            return findKthLargest(nums, right + 1, r, k);
        }
    }

    // 就是去找从小到大排序 位置是i的那个数
    // 这个复杂度是：时间复杂度O(n)，额外空间复杂度O(1)
    public static int randomizedSelect(int[] nums, int i) {
        int ans = 0;
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int x = nums[l + (int)(Math.random() * (r - l + 1))];
            partition(nums, l, r, x);
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    public static int first, last;
    public static void partition(int[] nums, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (nums[i] == x) {
                i++;
            } else if (nums[i] < x) {
                swap(nums, first++, i++);
            } else {
                swap(nums, i, last--);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
