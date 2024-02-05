package class35;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName: Algo_035_6_Maximum_Frequency_Stack
 * Package: class35
 * CreateTime: 2024/2/4 22:31
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/maximum-frequency-stack/description/
public class Algo_035_6_Maximum_Frequency_Stack {

    public static class FreqStack {

        public int maxCount; // 统计当前最大次数
        // 第一个int表示出现第几次，后面一个链表按序表示这个频次出现的val
        public HashMap<Integer, ArrayList<Integer>> cntVal;
        // key: 当前输入数字，value: 该数字频次
        public HashMap<Integer, Integer> freq;

        public FreqStack() {
            maxCount = 0;
            cntVal = new HashMap<>();
            freq = new HashMap<>();
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            int curCount = freq.get(val);
            maxCount = Math.max(maxCount, curCount);
            if (!cntVal.containsKey(curCount)) {
                cntVal.put(curCount, new ArrayList<>());
            }
            ArrayList<Integer> curCountVals = cntVal.get(curCount);
            curCountVals.add(val);
        }

        public int pop() {
            ArrayList<Integer> topCountVals = cntVal.get(maxCount);
            int ans = topCountVals.remove(topCountVals.size() - 1);
            if (topCountVals.size() == 0) {
                cntVal.remove(maxCount--);
            }
            int times = freq.get(ans);
            if (times == 1) {
                freq.remove(ans);
            } else {
                freq.put(ans, times - 1);
            }
            return ans;
        }
    }
}
