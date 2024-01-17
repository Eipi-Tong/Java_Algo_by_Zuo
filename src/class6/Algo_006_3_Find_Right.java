package class6;

import java.util.Arrays;
import class5.Algo_005_Judge_Debug;

/**
 * ClassName: class6.Algo_006_3_Find_Right
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 23:02
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_006_3_Find_Right {

    public static void main (String[] args) {
        int N = 20;
        int V = 100;
        int testTimes = 200;
        System.out.println("Test Start");
        for (int i = 0; i < testTimes; i++) {
            int n = (int)(Math.random() * N);
            int[] arr = Algo_005_Judge_Debug.randomArray(n, V);
            Arrays.sort(arr);
            int num = (int)(Math.random() * N);
            if (validate(arr, num) != findRight(arr, num)) {
                System.out.println("Wrong Answer");
                Algo_005_Judge_Debug.printArray(arr);
                // print arr
            }
        }
        System.out.println("Test End");
    }

    /**
     * 查看在有序数组arr中，<= num的最右位置
     * @param arr 有序数组
     * @param num
     * @return
     */
    public static int findRight (int[] arr, int num) {
        int index = -1; // 也就是答案
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= num) {
                // 记录答案，向右侧二分
                index = m;
                l = m + 1;

            } else {
                // 不记录答案，向左侧二分
                r = m - 1;
            }
        }
        return index;
    }

    // 对数器
    public static int validate (int[] arr, int num) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }
}
