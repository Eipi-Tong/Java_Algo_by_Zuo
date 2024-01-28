package class31;

/**
 * ClassName: Algo_031_3_Near_Two_Power
 * Package: class31
 * CreateTime: 2024/1/28 14:14
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 返回大于等于n的最小的2的幂
// 如果int范围内不存在这样的数，返回整数最小值
public class Algo_031_3_Near_Two_Power {

    public static void main(String[] args) {
        int num = 26;
        System.out.println(near2Pow(num));
    }

    public static int near2Pow(int num) {
        if (num <= 0) {
            return 1;
        }
        num--;    // 必须先减1 因为num可能本身就是2的幂
        // 将这个数变为：从最左侧的1开始右侧全是1的数
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;
        return num + 1;  // 最后加1相当于进位
    }
}
