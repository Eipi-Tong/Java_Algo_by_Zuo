package class21;

/**
 * ClassName: Algo_021_1_Merge_Sort
 * Package: class21
 * CreateTime: 2024/1/24 12:44
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_021_0_Merge_Sort_My {

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 3, 9, 5, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, r, m + 1);
    }

    public static void merge(int[] arr, int l, int r, int m) {
        System.out.println("Cur l, r, m: "+ l + " " + r + " " + m);
        int[] temp = new int[r - l + 1];
        int pl = l, pr = m;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (pl < m && pr <= r) ? (arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++]) : ((pl >= m) ? arr[pr++] : arr[pl++]);
        }
        System.out.print("Here is ");
        for (int i = l; i <= r; i++) {
            System.out.print(temp[i - l] + " ");
            arr[i] = temp[i - l];
        }
        System.out.println();
    }
}
