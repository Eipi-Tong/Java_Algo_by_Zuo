package class23;

/**
 * ClassName: Algo_023_2_Quick_Sort
 * Package: class23
 * CreateTime: 2024/1/25 15:39
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_023_2_Quick_Sort {

    public static int[] sortArray(int[] nums) {
        quickSort1(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort1(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l + (int) (Math.random() * (r - l + 1))];
        int mid = partition1(nums, l, r, x);
        quickSort1(nums, l, mid - 1);
        quickSort1(nums, mid + 1, r);
    }

    public static int partition1(int[] nums, int l, int r, int x) {
        int a = l, xi = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, a, i);
                xi = (nums[a] == x) ? a : xi;
                a++;
            }
        }
        swap(nums, a - 1, xi);
        return a - 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort2(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l + (int)(Math.random() * (r - l + 1))];
        partition2(nums, l, r, x);
        int left = first, right = last;
        quickSort2(nums, l, left - 1);
        quickSort2(nums, right + 1, r);
    }

    public static int first, last;
    public static void partition2(int[] nums, int l, int r, int x) {
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
}
