package class35;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName: Algo_035_3_Insert_Delete_Random
 * Package: class35
 * CreateTime: 2024/2/4 19:29
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Algo_035_3_Insert_Delete_Random {

    public static class RandomizedSet {

        public HashMap<Integer, Integer> map;
        public ArrayList<Integer> arr;

        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int valIndex = map.get(val);
            int endValue = arr.get(arr.size() - 1);
            map.put(endValue, valIndex);
            arr.set(valIndex, endValue);
            map.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }

        public int getRandom() {
            int n = (int) (Math.random() * arr.size());
            return arr.get(n);
        }
    }
}
