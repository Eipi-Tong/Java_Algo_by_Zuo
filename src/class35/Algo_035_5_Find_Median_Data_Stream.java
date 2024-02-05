package class35;

import java.util.PriorityQueue;

/**
 * ClassName: Algo_035_5_Find_Median_Data_Stream
 * Package: class35
 * CreateTime: 2024/2/4 22:30
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/find-median-from-data-stream/description/
public class Algo_035_5_Find_Median_Data_Stream {

    public static class MedianFinder {

        public PriorityQueue<Integer> maxHeap;
        public PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek();
            }
        }
    }
}
