package class31;

/**
 * ClassName: Algo_031_5_Reverse_Bits
 * Package: class31
 * CreateTime: 2024/1/28 14:38
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/reverse-bits/description/
public class Algo_031_5_Reverse_Bits {
    // you need treat n as an unsigned value

    /**
     * a b c d e f g h  原
     * b a d c f e h g  1v1 swap
     * d c b a h g f e  2v2 swap
     * h g f e d c b a  4v4 swap
     */
    public int reverseBits(int n) {
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        n = (n >>> 16) | (n << 16);
        return n;
    }
}
