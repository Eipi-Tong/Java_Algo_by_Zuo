package class3;

/**
 * ClassName: Algo_003_Binary_Systems
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 16:17
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_003_Binary_System {

    public static void main (String[] args) {
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===+===");
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===+===");
        int c = 0b1001110;
        System.out.println(c);
        printBinary(c);
        System.out.println("===+===");
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("===+===");

        // 相反数
        int e = ~a + 1;
        System.out.println(e);
        printBinary(e);
        System.out.println("===+===");
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);
        System.out.println(-f);
        printBinary(-f);
        System.out.println(~f + 1);
        printBinary(~f + 1);
        System.out.println("===+===");

        // 位运算
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        printBinary(g ^ h);
        System.out.println("===+===");

        // 注意：位运算的 & 和 | 和 逻辑运算的 && 和 || 的区别

        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("===+===");
        printBinary(i);
        printBinary(i >> 1);
        printBinary(i >> 2);
        printBinary(i >> 3);
        printBinary(i >>> 3);
        System.out.println("===+===");
        int j = 0xf0000000;
        printBinary(j);
        printBinary(j >> 2);  // 用符号位补全
        printBinary(j >>> 2); // 用0补全
        System.out.println("===+===");
        // 对于非负数 << 1 == * 2
        // 对于非负数 >> 1 == / 2
    }

    public static void printBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            // 如果是long类型。应该是  n & (1L << 48)
            System.out.print((n & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
