package class30;

/**
 * ClassName: Algo_030_5_Double_Number
 * Package: class30
 * CreateTime: 2024/1/27 19:50
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/single-number-iii/description/
public class Algo_030_5_Double_Number {
    /**
     * Brian Kernighan算法
     * 提取二进制状态中最右侧的1
     * 即   01101000  -> 00001000
     * 取反 10010111  + 1 = 10011000
     * 两者相与 即可
     * x & (~x + 1)，即 (x & -x)
     */
    public static int[] singleNumber(int[] nums) {
        int eor1 = 0;
        for (int ele: nums) {
            eor1 ^= ele;
        }
        // 假设要求的两个字是a和b，此时 eor1 = a ^ b
        int rightOne = eor1 & -eor1;
        // 根据rightOne划分正营
        int eor2 = 0;
        for (int ele: nums) {
            if ((ele & rightOne) == 0) {
                eor2 ^= ele;
            }
        }
        eor1 = eor1 ^ eor2;
        return new int[]{eor1, eor2};
    }
}
