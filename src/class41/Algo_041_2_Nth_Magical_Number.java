package class41;

/**
 * ClassName: Algo_041_2_Nth_Magical_Number
 * Package: class41
 * CreateTime: 2024/2/27 12:41
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_041_2_Nth_Magical_Number {

    public static int nthMagicalNumber(int n, int a, int b) {
        final long MOD = (long) 1e9+7;
        long lcm = lcm(a, b);
        long ans = 0;
        for (long l = 0, r = (long) n * Math.min(a, b); l <= r;) {
            long m = (l + r) / 2;
            if (m / a + m / b - m / lcm >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) (ans % MOD);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (long) a / gcd(a, b) * b;
    }
}
