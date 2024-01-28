package class31;

/**
 * ClassName: Algo_031_1_Pow_Of_Two
 * Package: class31
 * CreateTime: 2024/1/28 14:02
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/power-of-two/description/
public class Algo_031_1_Pow_Of_Two {

    public static boolean isPowerOfTwo(int n) {
        // 利用Brian Kernighan算法提取最右侧的1 与原数字n相同 n一定是2的幂
        return (n > 0) && n == (n & -n);
    }
}
