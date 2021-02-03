package test;

import leetcode.Solution208;
import leetcode.Solution300;

import java.util.Arrays;

public class LeetcodeTests {
    public static final int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 18};

    public static final Solution300 lis = new Solution300();
    public static final Solution208 trie = new Solution208();

    public static void main(String[] args) {
        LeetcodeTests testEntity = new LeetcodeTests();
        // testEntity.test300();
        testEntity.test208();
    }

    private void test300() {
        System.out.println("LIS of " + Arrays.toString(arr) + " = " + lis.lengthOfLIS(arr));
        System.out.println("LIS of " + Arrays.toString(arr) + " = " + lis.lengthOfLIS2(arr));
    }

    private void test208() {
        trie.insert("apple");
        System.out.println(trie.search("apple")); // 返回 true
        System.out.println(trie.search("app")); // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 true
    }
}
