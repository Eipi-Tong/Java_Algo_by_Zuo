package class35;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: Algo_035_7_All_O_One
 * Package: class35
 * CreateTime: 2024/2/4 22:33
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/all-oone-data-structure/description/
public class Algo_035_7_All_O_One {

    public static class AllOne {

        public class Bucket {
            public int cnt;
            public HashSet<String> set;
            public Bucket last;
            public Bucket next;

            public Bucket(String s, int c) {
                set = new HashSet<>();
                set.add(s);
                cnt = c;
            }
        }

        // 已知cur 在其后面插入pos
        public void insert(Bucket cur, Bucket pos) {
            cur.next.last = pos;
            pos.next = cur.next;
            cur.next = pos;
            pos.last = cur;
        }

        public void remove(Bucket cur) {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }

        public Bucket head;
        public Bucket tail;
        HashMap<String, Bucket> map;

        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.last = head;
            map = new HashMap<>();
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                if (head.next.cnt == 1) {
                    map.put(key, head.next);
                    head.next.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, 1);
                    map.put(key, newBucket);
                    insert(head, newBucket);
                }
            } else {
                Bucket bucket = map.get(key);
                if (bucket.next.cnt == bucket.cnt + 1) {
                    map.put(key, bucket.next);
                    bucket.next.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt + 1);
                    map.put(key, newBucket);
                    insert(bucket, newBucket);
                }
                bucket.set.remove(key);
                if (bucket.set.isEmpty()) {
                    remove(bucket);
                }
            }
        }

        public void dec(String key) {
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) {
                map.remove(key);
            } else {
                if (bucket.last.cnt == bucket.cnt - 1) {
                    map.put(key, bucket.last);
                    bucket.last.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    insert(bucket.last, newBucket);
                }
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }

        public String getMaxKey() {
            return tail.last.set.iterator().next();
        }

        public String getMinKey() {
            return head.next.set.iterator().next();
        }
    }
}
