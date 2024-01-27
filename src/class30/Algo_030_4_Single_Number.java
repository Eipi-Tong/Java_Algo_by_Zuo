package class30;

/**
 * ClassName: Algo_030_4_Single_Number
 * Package: class30
 * CreateTime: 2024/1/27 19:47
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 其他全部出现偶数次，就一个出现了奇数次 即使用该方法
// https://leetcode.com/problems/single-number/
public class Algo_030_4_Single_Number {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int ele: nums) {
            ans ^= ele;
        }
        return ans;
    }
}
