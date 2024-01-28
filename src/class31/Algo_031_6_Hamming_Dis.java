package class31;

/**
 * ClassName: Algo_031_6_Hamming_Dis
 * Package: class31
 * CreateTime: 2024/1/28 14:49
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/hamming-distance/description/
public class Algo_031_6_Hamming_Dis {

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离
     */
    public static int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
        return countOnes(x ^ y);
    }

    // 返回n的二进制数中有几个1
    public static int countOnes(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
        return n;
    }
}
