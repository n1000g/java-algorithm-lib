package test;

import design.Trie;

public class DesignTests {
    private static Trie trie;
    public static void main(String[] args) {
        testTrie();
    }

    private static void testTrie() {
        trie.insert("test");
        System.out.println(trie.search("test")); // 返回 true
        System.out.println(trie.search("te")); // 返回 false
        System.out.println(trie.startsWith("te")); // 返回 true
        trie.insert("te");
        System.out.println(trie.search("te")); // 返回 true
    }

}
