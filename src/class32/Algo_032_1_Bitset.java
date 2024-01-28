package class32;

import java.util.HashSet;

/**
 * ClassName: Algo_032_1_Bitset
 * Package: class32
 * CreateTime: 2024/1/28 15:06
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 实现一个位图（类似集合的结构） 必须是连续范围
public class Algo_032_1_Bitset {

    public static class Bitset {
        public int[] set;

        // 小技巧：要使得a/b向上取整，即(a+b-1)/b
        public Bitset(int n) {
            set = new int[(n + 31) / 32];
        }

        public void add(int num) {
            set[num / 32] |= (1 << (num % 32));
        }

        public void remove(int num) {
            set[num / 32] &= ~(1 << (num % 32));
        }

        public void reverse(int num) {
            set[num / 32] ^= (1 << (num % 32));
        }

        public boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }

    public static void main(String[] args) {
        int n = 5000;
        int testTimes = 10000;
        Bitset bitSet = new Bitset(n);
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("Start TestTimes!");
        for (int i= 0; i < testTimes; i++) {
            int decide = (int) (Math.random() * 3);  // 0 1 2 三种情况
            int number = (int) (Math.random() * n);
            if (decide == 0) {
                bitSet.add(number);
                hashSet.add(number);
            } else if (decide == 1) {
                bitSet.remove(number);
                hashSet.remove(number);
            } else {
                bitSet.reverse(number);
                if (hashSet.contains((number))) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("End TestTimes!");
        System.out.println("Start Validate!");
        for (int i = 0; i < n; i++) {
            if (bitSet.contains(i) != hashSet.contains(i)) {
                System.out.println("Something Wrong.");
            }
        }
        System.out.println("End Validate!");
    }
}
