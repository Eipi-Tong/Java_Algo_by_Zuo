package class27;

import java.util.PriorityQueue;

/**
 * ClassName: Algo_027_3_MinOps_To_Halve_Array_Sum
 * Package: class27
 * CreateTime: 2024/1/26 17:28
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_027_3_MinOps_To_Halve_Array_Sum {

    public static int halveArray1(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<Double>((a, b) -> b.compareTo(a)); // double 不能用 b-a
        double sum = 0;
        for (double ele: nums) {
            heap.add(ele);
            sum += ele;
        }

        int ans = 0;
        double reduced = 0;
        while (reduced < sum / 2) {
            double x = heap.poll();
            reduced += x / 2;
            heap.add(x / 2);
            ans++;
        }
        return ans;
    }

    public static final int MAXN = (int) 1e6 + 1;
    public static double[] heap = new double[MAXN];
    public static int size;

    public static int halveArray2(int[] nums) {
        double sum = 0;
        size = 0;
        for (double ele : nums) {
            heapInsert(ele);
            sum += ele;
        }

        int ans = 0;
        double reduced = 0;
        while (reduced < sum / 2) {
            double x = heapify();
            reduced += x / 2;
            heapInsert(x / 2);
            ans++;
        }
        return ans;
    }

    public static void heapInsert(double x) {
        int i = size++;
        heap[i] = x;
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static double heapify() {
        double ans = heap[0];
        swap(0, --size);
        int i = 0, l = i * 2 + 1;
        while (l < size) {
            int best = (l + 1 < size) && (heap[l + 1] > heap[l]) ? l + 1 : l;
            if (heap[i] >= heap[best])
                break;
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
        return ans;
    }

    public static void swap(int i, int j) {
        double temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    // 双精度double 转 long 优化
    public static long[] heap3 = new long[MAXN];
    public static int size3;

    public static int halveArray3(int[] nums) {
        size3 = nums.length;
        long sum = 0;
        for (int i = size3 - 1; i >= 0; i--) {
            heap3[i] = (long) nums[i] << 20;
            sum += heap3[i];
            heapify(i);
        }
        sum /= 2;
        int ans = 0;
        for (long minus = 0; minus < sum; ans++) {
            heap3[0] /= 2;
            minus += heap3[0];
            heapify(0);
        }
        return ans;
    }

    public static void heapify(int i) {
        int l = i * 2 + 1;
        while (l < size3) {
            int best = l + 1 < size3 && heap3[l + 1] > heap3[l] ? l + 1 : l;
            best = heap3[best] > heap3[i] ? best : i;
            if (best == i) {
                break;
            }
            swap3(best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap3(int i, int j) {
        long tmp = heap3[i];
        heap3[i] = heap3[j];
        heap3[j] = tmp;
    }
}
