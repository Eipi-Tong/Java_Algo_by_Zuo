package class44;

import java.security.spec.EdDSAParameterSpec;
import java.util.HashMap;

/**
 * ClassName: Algo_044_1_Trie_Tree
 * Package: class44
 * CreateTime: 2024/3/5 13:28
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Algo_044_1_Trie_Tree {

    class Trie {

        public final int ALPHA = 26;

        public class TrieNode {
            public int pass;
            public int end;
            public TrieNode[] nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[ALPHA];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (node.nexts[x] == null) {
                    node.nexts[x] = new TrieNode();
                }
                node = node.nexts[x];
                node.pass++;
            }
            node.end++;
        }

        // 如果之前word插入过前缀树，那么此时删掉一次
        // 如果之前word没有插入过前缀树，那么什么也不做
        public void erase(String word) {
            if (countWordsEqualTo(word) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0; i < word.length(); i++) {
                    int path = word.charAt(i) - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (node.nexts[x] == null) {
                    return false;
                }
                node = node.nexts[x];
            }
            return node.end > 0 ? true : false;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int x = prefix.charAt(i) - 'a';
                if (node.nexts[x] == null) {
                    return false;
                }
                node = node.nexts[x];
            }
            return true;
        }

        // 查询前缀树里，word单词出现了几次
        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        // 查询前缀树里，有多少单词以pre做前缀
        public int countWordsStartingWith(String pre) {
            TrieNode node = root;
            for (int i = 0; i < pre.length(); i++) {
                int path = pre.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }
    }

    // 路是哈希表实现的
    class Trie2 {

        public class TrieNode {
            public int pass;
            public int end;
            public HashMap<Integer, TrieNode> nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }

        private TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (!node.nexts.containsKey(x)) {
                    node.nexts.put(x, new TrieNode());
                }
                node = node.nexts.get(x);
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0; i < word.length(); i++) {
                    int x = word.charAt(i) - 'a';
                    if (--node.nexts.get(x).pass == 0) {
                        node.nexts.remove(x);
                        return;
                    }
                    node = node.nexts.get(x);
                }
                node.end--;
            }
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                if (!node.nexts.containsKey(x)) {
                    return 0;
                }
                node = node.nexts.get(x);
            }
            return node.end;
        }

        public int countWordsStartingWith(String pre) {
            TrieNode node = root;
            for (int i = 0; i < pre.length(); i++) {
                int x = pre.charAt(i) - 'a';
                if (!node.nexts.containsKey(x)) {
                    return 0;
                }
                node = node.nexts.get(x);
            }
            return node.pass;
        }
    }
}
