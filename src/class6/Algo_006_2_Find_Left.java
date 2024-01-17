package class6;

import java.util.Arrays;
import class5.Algo_005_Judge_Debug;

/**
 * ClassName: class6.Algo_006_2_Find_Left
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 22:42
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_006_2_Find_Left {

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
            if (validate(arr, num) != findLeft(arr, num)) {
                System.out.println("Wrong Answer");
                Algo_005_Judge_Debug.printArray(arr);
                // print arr
            }
        }
        System.out.println("Test End");
    }

    /**
     * 查看在有序数组arr中，>= num的最左位置
     * @param arr 有序数组
     * @param num
     * @return
     */
    public static int findLeft (int[] arr, int num) {
        int index = -1; // 也就是答案
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            /**
             * m = (l + r) / 2;
             * m = l + ((r - l) >> 1);
             * m = l + (r - l) / 2;
             * 这三种写法全是等效的
             * 但是：如果 l 和 r 都很大时， l + r 可能溢出
             * 所以：尽可能写下面的方法
             */
            if (arr[m] >= num) {
                // 记录答案
                index = m;
                r = m - 1;
            } else {
                // 不记录答案
                l = m + 1;
            }
        }
        return index;
    }

    // 对数器
    public static int validate (int[] arr, int num) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }
}
