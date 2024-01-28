package class31;

/**
 * ClassName: Algo_031_2_Pow_Of_Three
 * Package: class31
 * CreateTime: 2024/1/28 14:07
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/power-of-three/
public class Algo_031_2_Pow_Of_Three {

    /**
     * 找到int范围内 3最大的幂为MAX_POW_THREE = 3^19 = 1162261467
     * 所有3的幂 都且仅是 它的因子
     */
    public static final int MAX_POW_THREE = (int) Math.pow(3, 19);

    public static boolean isPowerOfThree(int n) {
        return (n > 0) && (MAX_POW_THREE % n == 0);
    }
}
