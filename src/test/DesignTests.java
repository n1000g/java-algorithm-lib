package test;

import design.*;

public class DesignTests {
    private static final Trie trie = new Trie();
    private static final DisjSets disjoint = new DisjSets(6);

    public static void main(String[] args) {
        // testTrie();
        testDisjoint();
    }

    private static void testTrie() {
        trie.insert("test");
        System.out.println(trie.search("test")); // 返回 true
        System.out.println(trie.search("te")); // 返回 false
        System.out.println(trie.startsWith("te")); // 返回 true
        trie.insert("te");
        System.out.println(trie.search("te")); // 返回 true
    }

    private static void testDisjoint() {
        disjoint.union(1, 4);
        disjoint.union(5, 1);
        disjoint.union(1, 2);
        // disjoint.union(5, 2); // 错误输入
        System.out.println("find(0) = " + disjoint.find(0));
        System.out.println("find(1) = " + disjoint.find(1));
        System.out.println("find(2) = " + disjoint.find(2));
        System.out.println("find(3) = " + disjoint.find(3));
        System.out.println("find(4) = " + disjoint.find(4));
        System.out.println("find(5) = " + disjoint.find(5));
        // System.out.println("getCount() = " + disjoint.getCount());
        // System.out.println("isConnected(2, 0) = " + disjoint.isConnected(2, 0));
    }

}
