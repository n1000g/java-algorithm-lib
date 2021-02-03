package design;

/**
 * Trie 前缀树
 * leetcode 208
 */
public class Trie {

    private boolean isEnd;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) return null;
            node = node.next[c - 'a'];
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
}
