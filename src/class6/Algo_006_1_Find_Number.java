package class6;

import java.util.Arrays;
import class5.Algo_005_Judge_Debug;

/**
 * ClassName: Algo_006_Binary_Search
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 22:18
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */

// 查看在有序数组arr中，num是否存在
public class Algo_006_1_Find_Number {

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
            if (validate(arr, num) != exist(arr, num)) {
                System.out.println("Wrong Answer");
                Algo_005_Judge_Debug.printArray(arr);
                // print arr
            }
        }
        System.out.println("Test End");
    }

    /**
     * 查看在有序数组arr中，num是否存在
     * @param arr 有序数组
     * @param num 待查找的值
     * @return
     */
    public static boolean exist (int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    // 对数器
    public static boolean validate (int[] arr, int num) {
        for (int cur: arr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }
}
