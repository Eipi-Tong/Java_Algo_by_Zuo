package class6;

import class5.Algo_005_Judge_Debug;

import java.util.Arrays;

/**
 * ClassName: class6.Algo_006_4_Find_Peak
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 23:18
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_006_4_Find_Peak {
    /**
     * 数组中任意两个相邻位置不等
     * 峰值表示该位置数大于左右两个相邻的值
     * 返回其中的一个峰值
     * @param args
     */
    // 二分搜索不一定发生在有序数组上（比如寻找峰值问题）
    public static void main (String[] args) {
        System.out.println("Test Start");
        int[] arr = new int[]{1,2,3,6,2,6,8,1};
        if (validate(arr) != findPeak(arr)) {
            System.out.println("Wrong Answer");
            Algo_005_Judge_Debug.printArray(arr);
            // print arr
        }
        System.out.println("Test End");
    }

    public static int findPeak (int[] arr) {
        int n = arr.length;
        // 数组长度等于1，就是第一个元素
        if (n == 1) {
            return 0;
        }
        // 数组长度>=2，验证0位置或n-1位置
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        // 中间一定有峰之点，在这个范围二分
        int l = 1, r = n - 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m + 1] > arr[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 这个对数器写的不对
    public static int validate (int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return i - 1;
            }
        }
        return arr[n - 1];
    }
}
