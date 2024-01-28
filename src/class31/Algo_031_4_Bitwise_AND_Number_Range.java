package class31;

/**
 * ClassName: Algo_031_4_Bitwise_AND_Number_Range
 * Package: class31
 * CreateTime: 2024/1/28 14:28
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
public class Algo_031_4_Bitwise_AND_Number_Range {
    // 将left和right区间上的所有整数求与的结果
    public static int rangeBitwiseAnd(int left, int right) {
        // 当left<right时，最右侧的1一定留不下来
        while (left < right) {
            right -= right & -right;
        }
        // 不用关注左侧，因为右侧即已经依靠left<right决定
        return right;
    }
}
