package review;

import java.util.Arrays;

/**
 * ClassName: Sort
 * Package: review
 * CreateTime: 2024/2/18 18:24
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Code01_Sort {

    public static void main(String[] args) {
        int[] nums = generateArray();
        sortArray_1(nums);
        printArray(nums, "冒泡排序：");
        nums = generateArray();
        sortArray_2(nums);
        printArray(nums, "选择排序：");
        nums = generateArray();
        sortArray_3(nums);
        printArray(nums, "插入排序：");

        printArray(sortArray_4(generateArray()), "归并排序：");
        printArray(sortArray_5(generateArray()), "快速排序：");
        printArray(sortArray_6(generateArray()), "堆排序：");
        printArray(sortArray_7(generateArray()), "基数排序：");
    }

    public static int[] generateArray() {
        return new int[]{3, 1, 2, 7, -8, 9, 10, 7, 78, 5, 45};
    }

    public static void printArray(int[] nums, String mention) {
        System.out.print(mention);
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void sortArray_1(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public static void sortArray_2(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public static void sortArray_3(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static final int MAXN = (int) 1e6+1;
    public static int[] mergeHelp = new int[MAXN];

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public static int[] sortArray_4(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int i = l, a = l, b = m + 1;
        while (a <= m && b <= r) {
            mergeHelp[i++] = nums[a] <= nums[b] ? nums[a++] : nums[b++];
        }
        while (a <= m) {
            mergeHelp[i++] = nums[a++];
        }
        while (b <= r) {
            mergeHelp[i++] = nums[b++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = mergeHelp[i];
        }
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public static int[] sortArray_5(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static int first, last;

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[(int) (Math.random() * (r - l + 1)) + l];
        partition(nums, l, r, x);
        int left = first, right = last;
        quickSort(nums, l, left - 1);
        quickSort(nums, right + 1, r);
    }

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

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public static int[] sortArray_6(int[] nums) {
        // 调整成大根堆
        heapSort(nums);
        return nums;
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
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

    public static final int BASE = 10;
    public static int[] help = new int[MAXN];
    public static int[] cnts = new int[BASE];

    /**
     * 基数排序
     * @param nums
     * @return
     */
    public static int[] sortArray_7(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
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
        int ans = 0;
        while (num > 0) {
            ans++;
            num /= BASE;
        }
        return ans;
    }

    public static void radixSort(int[] nums, int bits) {
        int n = nums.length;
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[(nums[i] / offset) % BASE]++;
            }
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
