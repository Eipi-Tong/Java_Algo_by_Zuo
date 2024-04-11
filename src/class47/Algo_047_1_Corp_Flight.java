package class47;

/**
 * ClassName: Algo_047_1_Corp_Flight
 * Package: class47
 * CreateTime: 2024/4/10 23:10
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_047_1_Corp_Flight {
    // https://leetcode.cn/problems/corporate-flight-bookings/
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] ele: bookings) {
            int first = ele[0], last = ele[1], seat = ele[2];
            ans[first - 1] += seat;
            if (last != n) {
                ans[last] -= seat;
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
