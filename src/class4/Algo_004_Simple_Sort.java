package class4;

/**
 * ClassName: class4.Algo_004_Simple_Sort
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 17:30
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_004_Simple_Sort {

    public static void main (String[] args) {
        int[]arr1 = new int[]{3, 9, 4, 13, 6, 10, 1};
        SelectSort(arr1);
        printArr(arr1);
        System.out.println("===+===");
        int[]arr2 = new int[]{3, 9, 4, 13, 6, 10, 1};
        BubbleSort(arr2);
        printArr(arr2);
        System.out.println("===+===");
        int[]arr3 = new int[]{3, 9, 4, 13, 6, 10, 1};
        InsertSort(arr3);
        printArr(arr3);
        System.out.println("===+===");
    }

    // i~n-1范围内，找到最小值并放在i位置上，然后i+1~n-1范围内继续
    public static void SelectSort (int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 0~i范围内，相邻位置较大的数滚下去，最大值来到i位置，然后0~i-1范围内继续
    public static void BubbleSort (int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 0~i范围内已经有序，新来的数从右往左滑到不再小的位置插入，然后继续
    public static void InsertSort(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
