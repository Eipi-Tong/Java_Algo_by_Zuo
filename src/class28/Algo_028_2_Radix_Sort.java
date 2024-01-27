package class28;

import java.util.Arrays;

/**
 * ClassName: Algo_028_2_Radix_Sort
 * Package: class28
 * CreateTime: 2024/1/27 12:46
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_028_2_Radix_Sort {

    public static final int MAXN = (int) 1e6+1;
    public static final int BASE = 10;
    public static int[] help = new int[MAXN];
    public static int[] cnts = new int[BASE];

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int n = nums.length;
        int minn = nums[0];
        for (int i = 1; i < n; i++) {
            minn = Math.min(minn, nums[i]);
        }
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            nums[i] -= minn;
            maxn = Math.max(maxn, nums[i]);
        }
        radixSort(nums, bits(maxn));
        for (int i = 0; i < n; i++) {
            nums[i] += minn;
        }
        return nums;
    }

    public static int bits(int num) {
        int bits = 0;
        while (num > 0) {
            bits++;
            num /= BASE;
        }
        return bits;
    }

    public static void radixSort(int[] nums, int bits) {
        int n = nums.length;
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[(nums[i] / offset) % BASE]++;
            }
            // 要统计前缀和
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(nums[i] / offset) % BASE]] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                nums[i] = help[i];
            }
        }
    }
}
