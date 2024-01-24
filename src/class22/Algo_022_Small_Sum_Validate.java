package class22;

/**
 * ClassName: Algo_022_Small_Sum_Validate
 * Package: class22
 * CreateTime: 2024/1/24 16:21
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_022_Small_Sum_Validate {

    public static final int MAXN = (int)1e6+1;
    public static int[] help = new int[MAXN];

    public static void main(String[] args) {
        int N = 10;
        int V = 100;
        int testTimes = 100;
        System.out.println("Test Start");
        for (int i = 0; i < testTimes; i++) {
            int n = (int)(Math.random() * N) + 1;   // 保证数组不为空
            int[] arr = randomArray(n, V);
//            int[] arr = {1, 3, 5, 2, 4, 6};
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            long ans1 = smallSum(arr1, 0, arr1.length - 1);
            long ans2 = validate(arr2);
            if (ans1 != ans2) {
                System.out.println("Wrong Answer -- ans1: "+ ans1 + ", ans2: " + ans2);
                printArray(arr);
            }
        }
        System.out.println("Test End");
    }

    public static long smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(arr, l, m) + smallSum(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static long merge(int[] arr, int l, int m, int r) {
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }

        int i = l, a = l, b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = (arr[a] <= arr[b]) ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }

    public static long validate(int[] arr) {
        int n = arr.length;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            long temp = 0;
            for (int j = 0; j < i; j++) {
                temp = (arr[j] <= arr[i]) ? (temp + arr[j]) : temp;
            }
            ans += temp;
        }
        return ans;
    }

    public static int[] randomArray (int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
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

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
