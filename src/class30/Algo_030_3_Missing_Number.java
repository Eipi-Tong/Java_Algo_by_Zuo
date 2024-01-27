package class30;

/**
 * ClassName: Algo_030_3_Missing_Number
 * Package: class30
 * CreateTime: 2024/1/27 19:39
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/missing-number/description/
public class Algo_030_3_Missing_Number {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xorAll = 0, xorHas = 0;
        for (int i = 0; i < n; i++) {
            xorAll ^= i;
            xorHas ^= nums[i];
        }
        xorAll ^= n;
        return xorAll ^ xorHas;
    }
}
