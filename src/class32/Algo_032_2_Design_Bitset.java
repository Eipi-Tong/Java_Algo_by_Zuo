package class32;

/**
 * ClassName: Algo_032_2_Design_Bitset
 * Package: class32
 * CreateTime: 2024/1/28 16:31
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_032_2_Design_Bitset {

    public static class Bitset {

        public static final int BITS = 32;
        public static int[] set;
        public static int size;
        public static int ones;
        public static int zeros;
        public static boolean reverse;   // flip用于反转

        public Bitset(int size) {
            this.size = size;
            this.ones = 0;
            this.zeros = size;
            this.reverse = false;
            this.set = new int[(size + BITS - 1) / BITS];
        }

        public int getValue(int idx) {
            int num = set[idx / BITS];
            num &= (1 << (idx % BITS));
            return num;
        }

        public void fix(int idx) {
            if (!reverse) {
                if (getValue(idx) == 0) {
                    ones++;
                    zeros--;
                    set[idx / BITS] |= (1 << (idx % BITS));
                }
            } else {
                if (getValue(idx) != 0) {
                    ones++;
                    zeros--;
                    set[idx / BITS] ^= (1 << (idx % BITS));
                }
            }
        }

        public void unfix(int idx) {
            if (!reverse) {
                if (getValue(idx) != 0) {
                    ones--;
                    zeros++;
                    set[idx / BITS] ^= (1 << (idx % BITS));
                }
            } else {
                if (getValue(idx) == 0) {
                    ones--;
                    zeros++;
                    set[idx / BITS] |= (1 << (idx % BITS));
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int temp = ones;
            ones = zeros;
            zeros = temp;
        }

        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, k = 0; i < size; k++) {
                for (int j = 0; j < BITS && i < size; j++, i++) {
                    int status = (set[k] >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    builder.append(status);
                }
            }
            return builder.toString();
        }
    }

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
}
