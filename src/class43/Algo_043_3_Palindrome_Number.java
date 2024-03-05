package class43;

/**
 * ClassName: Algo_043_3_Palindrom
 * Package: class43
 * CreateTime: 2024/3/5 13:24
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/palindrome-number/
public class Algo_043_3_Palindrome_Number {

    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int offset = 1;
        while (num / offset >= 10) {
            offset *= 10;
        }
        while (num != 0) {
            if (num / offset != num % 10) {
                return false;
            }
            num = (num % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}
