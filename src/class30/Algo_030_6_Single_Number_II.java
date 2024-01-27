package class30;

/**
 * ClassName: Algo_030_6_Single_Number_II
 * Package: class30
 * CreateTime: 2024/1/27 20:11
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/single-number-ii/description/
public class Algo_030_6_Single_Number_II {

    public static final int BITS = 32;
    public static final int M = 3;

    // 数组中除了一个数以外其他数都出现了m次，就这一个数出现次数<m，求该数
    public static int singleNumber(int[] nums) {
        // cnts[0] : 0位上有多少个1
        // cnts[i] : i位上有多少个1
        // cnts[31] : 31位上有多少个1
        int[] cnts = new int[BITS];
        for (int num: nums) {
            for (int i = 0; i < BITS; i++) {
                cnts[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < BITS; i++) {
            if ((cnts[i] % M) != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
