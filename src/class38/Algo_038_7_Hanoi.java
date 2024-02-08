package class38;

/**
 * ClassName: Algo_038_7_Hanoi
 * Package: class38
 * CreateTime: 2024/2/8 15:18
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 时间复杂度：O(2^n)
public class Algo_038_7_Hanoi {

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "左", "中", "右");
        }
    }

    public static void f(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("移动圆盘 1 从 " + from + " 到 " + to);
            return;
        }
        f(n - 1, from, other, to);
        System.out.println("移动圆盘 " + n + " 从 " + from + " 到 " + to);
        f(n - 1, other, to, from);
    }
}
