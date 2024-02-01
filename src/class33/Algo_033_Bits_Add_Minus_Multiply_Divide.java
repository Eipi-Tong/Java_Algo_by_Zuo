package class33;

/**
 * ClassName: Algo_033_Bits_Add_Minus_Multiply_Divide
 * Package: class33
 * CreateTime: 2024/1/29 15:40
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/divide-two-integers/description/
public class Algo_033_Bits_Add_Minus_Multiply_Divide {

    public static int add(int a, int b) {
        // 进位信息：(a & b) << 1
        // a + b  = a ^ b + 进位信息
        int ans = a;
        while (b != 0) {
            ans = a ^ b;   // 无进位相加的结果
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int neg(int n) {
        // -n = ~n + 1
        return add(~n, 1);
    }

    public static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);   //加上右侧
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (dividend != Integer.MIN_VALUE && divisor != Integer.MIN_VALUE) {
            return div(dividend, divisor);
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        // 此时 dividend == Integer。MIN_VALUE && divisor != Integer。MIN_VALUE
        if (divisor == neg(1)) {
            return Integer.MAX_VALUE;
        }
        dividend = add(dividend, divisor > 0 ? divisor : neg(divisor));
        int ans = div(dividend, divisor);
        int offset = divisor > 0 ? neg(1) : 1;   // 除数>0则补上-1，否则补上1
        return add(ans, offset);
    }

    // 必须保证a和b不是整数最小值INT_MIN，返回a/b结果
    public static int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) { // 必须用x右移来判断
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }
}
