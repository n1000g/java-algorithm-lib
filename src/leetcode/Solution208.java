package leetcode;

/**
 * 208. 实现 Trie (前缀树)
 *
 * Solution1
 *      每棵 Trie 由 TrieNode 组成
 *               并由 root 表示
 *      每个 TrieNode 是一个 多叉数状结构 或者 null
 */
public class Solution208 {

    private TrieNode root;

    public Solution208() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) return null;
            node = node.get(c);
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * 值就是索引
     * 所有节点保存值
     * 保存叶子节点标志
     */
    static class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return get(ch) != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}