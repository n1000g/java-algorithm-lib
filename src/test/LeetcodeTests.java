package test;

import leetcode.Solution300;

import java.util.Arrays;

public class LeetcodeTests {
    public static final int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 18};

    public static final Solution300 lis = new Solution300();

    public static void main(String[] args) {
        LeetcodeTests testEntity = new LeetcodeTests();
        testEntity.test300();
    }

    private void test300() {
        System.out.println("LIS of " + Arrays.toString(arr) + " = " + lis.lengthOfLIS(arr));
        System.out.println("LIS of " + Arrays.toString(arr) + " = " + lis.lengthOfLIS2(arr));
    }
}
