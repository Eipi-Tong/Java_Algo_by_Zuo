package class30;

/**
 * ClassName: Algo_030_1_Swap_XOR
 * Package: class30
 * CreateTime: 2024/1/27 16:06
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_030_1_Swap_XOR {

    public static void main(String[] args) {
        int a = 10;
        int b = -2313;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);

        int[] arr = {3, 5};
        swap(arr, 0, 1);
        System.out.println(arr[0] + " " + arr[1]);
        swap(arr, 0, 0);
        System.out.println(arr[0] + " " + arr[1]);
    }

    /**
     * 当 i ！= j 时，完全正确
     * 当 i == j 时，出错 arr[i] = 0, 所以别这么写
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
