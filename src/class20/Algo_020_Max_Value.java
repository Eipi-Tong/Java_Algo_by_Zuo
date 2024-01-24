package class20;

/**
 * ClassName: Algo_020_Max_Value
 * Package: class20
 * CreateTime: 2024/1/24 12:33
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_020_Max_Value {
    public static int maxValue(int[] arr) {
        return f(arr, 0, arr.length - 1);
    }

    // arr[l....r]范围上的最大值
    public static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int m = (l + r) / 2;
        int lmax = f(arr, l, m);
        int rmax = f(arr, m + 1, r);
        return Math.max(lmax, rmax);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        System.out.println("数组最大值 : " + maxValue(arr));
    }
}
