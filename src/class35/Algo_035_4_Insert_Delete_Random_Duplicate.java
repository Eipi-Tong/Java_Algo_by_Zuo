package class35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: Algo_035_4_Insert_Delete_Random_Duplicate
 * Package: class35
 * CreateTime: 2024/2/4 20:40
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
public class Algo_035_4_Insert_Delete_Random_Duplicate {

    public static class RandomizedCollection {

        // 多个下标组成一个集合
        public HashMap<Integer, HashSet<Integer>> map;
        public ArrayList<Integer> arr;

        public RandomizedCollection() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            arr.add(val);
            HashSet<Integer> set = map.getOrDefault(val, new HashSet<>());
            set.add(arr.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            HashSet<Integer> valSet = map.get(val);
            int valAnyIndex = valSet.iterator().next();  // 任意一个Index
            int endVal = arr.get(arr.size() - 1);
            if (val == endVal) {
                valSet.remove(arr.size() - 1);
            } else {
                HashSet<Integer> endValSet = map.get(endVal);
                endValSet.add(valAnyIndex);
                arr.set(valAnyIndex, endVal);
                endValSet.remove(arr.size() - 1);
                valSet.remove(valAnyIndex);
            }
            arr.remove(arr.size() - 1);
            if (valSet.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }
}
