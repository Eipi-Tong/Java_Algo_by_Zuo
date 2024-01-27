package class25;

/**
 * ClassName: Algo_025_2_Heap_Sort
 * Package: class25
 * CreateTime: 2024/1/26 12:09
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_025_2_Heap_Sort {
    public static int[] sortArray(int[] nums) {
//        heapSort1(nums);
        heapSort2(nums);
        return nums;
    }

    public static void heapSort1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }

    public static void heapSort2(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }

    public static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] nums, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = (l + 1 < size) && nums[l + 1] > nums[l] ? l + 1 : l;
            if (nums[best] <= nums[i]) {
                break;
            }
            swap(nums, i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
