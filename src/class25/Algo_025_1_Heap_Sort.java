package class25;

/**
 * ClassName: Algo_025_1_Heap_Sort
 * Package: class25
 * CreateTime: 2024/1/26 12:08
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */

import java.io.*;

/**
 *          0
 *    1          2
 *  3   4     5     6
 * 7 8 9 10 11 12 13 14
 * 堆相当于完全二叉树，其性质：
 * 如果当前结点是i
 * 父节点：(i - 1) / 2
 * 左孩子：2 * i + 1
 * 右孩子：2 * i + 2
 */
public class Algo_025_1_Heap_Sort {

    public static final int MAXN = (int)1e6+1;
    public static int[] arr = new int[MAXN];
    public static int n;  // array size

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int)in.nval;
            }
//            heapSort1();
            heapSort2();
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
        }
        out.flush();
        out.close();
    }

    /**
     * // 增倍分析法：当前的上限 是 乘上常数倍的下限
     * 经典堆排序 O(N * logN)
     * 从顶到底建大根堆，依次弹出顶；
     * 堆顶和堆底交换，然后size--
     */
    public static void heapSort1() {
        // 建堆 O(NlogN)
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }
        // 依次弹出  O(NlogN)
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    public static void heapSort2() {
        // 从底到顶建堆:O(N)
        // i 初始值可以是 n-1的父节点即 (n-2)/2 = n/2 - 1
        for (int i = n - 1; i >= 0; i--) {
            heapify(i, n);   // 向下找
        }
        // 依次弹出  O(NlogN)
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    /**
     * 大根堆（最大数top）向上调整
     * @param i 新加入的数字放在i位置，i会向上走直到所在的数不比父亲大或者是0位置
     * @return
     */
    public static void heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * i 位置的数变小了，大根堆（最大数top）需要向下调整
     * 当前堆的大小是size，和n是不一样的，是想象中在堆的数个数，不一定是全部的n！！！
     * @param i
     */
    public static void heapify(int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            // 进入该结构表示有左孩子
            // 这句话是评选 左右孩子中大的孩子的下标
            int best = (l + 1 < size) && (arr[l + 1] > arr[l]) ? l + 1 : l;
            // 如果孩子中最大的都不如当前的，就不需要交换了
            if (arr[best] <= arr[i]) {
                break;
            }
            swap(i, best);
            // i指向下面，l也指向下面
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
