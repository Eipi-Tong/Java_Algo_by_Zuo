package class22;

/**
 * ClassName: Algo_022_Reverse_Pairs
 * Package: class22
 * CreateTime: 2024/1/24 16:10
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_022_Reverse_Pairs {

    public static final int MAXN = (int)5e5+1;
    public static int[] help = new int[MAXN];

    public static int reversePairs(int[] arr) {
        return countPairs(arr, 0, arr.length - 1);
    }

    public static int countPairs(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return countPairs(arr, l, m) + countPairs(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int j = m + 1, i = l; j <= r; j++) {
            while (i <= m && (long)arr[i] <= (long)arr[j] * 2) {
                i++;
            }
            ans += (m - i + 1);
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
}
