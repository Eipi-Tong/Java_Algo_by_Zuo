package class5;

import class4.Algo_004_Simple_Sort;

/**
 * ClassName: class5.Algo_005_Judge_Debug
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 19:01
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */

// 对数器 - 用于验证程序

/*
1，你想要测的方法a（最优解）
2，实现复杂度不好但是容易实现的方法b（暴力解）
3，实现一个随机样本产生器（长度也随机、值也随机）
4，把方法a和方法b跑相同的输入样本，看看得到的结果是否一样
5，如果有一个随机样本使得比对结果不一致，打印这个出错的样本进行人工干预，改对方法a和方法b
6，当样本数量很多时比对测试依然正确，可以确定方法a（最优解）已经正确。
* */

public class Algo_005_Judge_Debug {

    public static void main (String[] args) {
        // 随机数组最大长度
        int N = 200;
        // 随机数组每个值 在1~V之间
        int V = 1000;
        // 测试次数
        int testTimes = 50000;
        System.out.println("Test Start");
        for (int i = 0; i < testTimes; i++) {
            // 随机得到长度 [0,N-1]
            int n = (int)(Math.random() * N);
            // 得到随机数组
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            Algo_004_Simple_Sort.SelectSort(arr1);
            Algo_004_Simple_Sort.BubbleSort(arr2);
            Algo_004_Simple_Sort.InsertSort(arr3);
            if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                System.out.println("Wrong Answer");
                printArray(arr);
                // print arr
            }
        }
        System.out.println("Test End");
    }

    /**
     * 得到一个随机数组
     * @param n 数据长度
     * @param v 数组中每个数都在 1~v 之间
     * @return
     */
    public static int[] randomArray (int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // Math.random() -> double -> [0, 1)一个小数
            // (Math.random() * v) -> double -> [0, v)一个小数
            // (int)(Math.random() * v) -> int -> 0 1 2 3 ... v-1
            // (int)(Math.random() * v) + 1 -> int -> 1 2 3 ... v
            arr[i] = (int)(Math.random() * v) + 1;
        }
        return arr;
    }

    public static int[] copyArray (int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean sameArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
