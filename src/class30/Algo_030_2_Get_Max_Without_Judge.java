package class30;

/**
 * ClassName: Algo_030_2_Get_Max_Without_Judge
 * Package: class30
 * CreateTime: 2024/1/27 16:15
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://www.nowcoder.com/practice/d2707eaf98124f1e8f1d9c18ad487f76
public class Algo_030_2_Get_Max_Without_Judge {

    // 在保证n是0或1的情况下，输入1则得到0，输入0则得到1
    public static int flip(int n) {
        return n ^ 1;
    }

    // 非负数返回1，负数返回0
    public static int sign(int n) {
        return flip(n >>> 31);  // 无符号右移
    }

    // 有溢出风险
    public static int getMax1(int a, int b) {
        int c = a - b;
        // c非负，returnA -> 1
        // c非负，returnB -> 0
        // c负数，returnA -> 0
        // c负数，returnB -> 1
        int returnA = sign(c);
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        // 判断A和B，符号是不是不一样，如果不一样diffAB=1，如果一样diffAB=0
        int diffAB = sa ^ sb;
        // 判断A和B，符号是不是一样，如果一样sameAB=1，如果不一样sameAB=0
        int sameAB = flip(diffAB);
        int returnA = diffAB * sa + sameAB * sc;  // 如果a，b不一样且a非负 或 a，b符号一样看c（此时不会溢出）
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        // getMax1方法会错误，因为溢出
        System.out.println(getMax1(a, b));
        // getMax2方法永远正确
        System.out.println(getMax2(a, b));
    }
}
