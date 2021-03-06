package test;

import leetcode.*;

import java.util.Arrays;
import java.util.List;

public class LeetcodeTests {
    public static final int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 18};

    public static final Solution300 lis = new Solution300();
    public static final Solution208 trie = new Solution208();
    public static final Solution212 q212 = new Solution212();
    public static final Solution547 q547 = new Solution547();
    public static final Solution200 q200 = new Solution200();

    public static void main(String[] args) {
        LeetcodeTests testEntity = new LeetcodeTests();
        // testEntity.test300();
        // testEntity.test208();
        // testEntity.test212();
        // testEntity.test547();
        testEntity.test200();
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

    private void test212() {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        List<String> q212Words = q212.findWords(board, words);
        System.out.println(Arrays.toString(q212Words.toArray()));
    }

    private void test547() {
        int[][] isConnected = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };
        System.out.println("q547.findCircleNum(isConnected) = " + q547.findCircleNum(isConnected));
    }

    private void test200() {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("q200.numIslands(grid) = " + q200.numIslands(grid));
    }
}
