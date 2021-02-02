package leetcode;

import java.util.Arrays;

/**
 * 300. LIS 最长上升子序列的大小
 *      经典 DP 问题、贪心
 */
public class Solution300 {

    /**
     * O(N^2) DP
     */
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示 以 nums[i] 结尾的数组的 LIS
        // dp[i] = max(dp[0]...dp[i-1]) if nums[i]<max(nums[0]...nums[i-1])
        //       = max(dp[0]...dp[i-1]) + 1 if nums[i]>max(nums[0]...nums[i-1])
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        // [4,10,4,3,8,9]
        //  1, 2,1,1,2,3
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * O(NlogN) 贪心
     * 假设最长上升子序列为 lis[]
     * lis[i] - lis[i-1] 足够小
     *
     * [3,9,3,1,2,7,8]
     * [3]
     * [3,9]
     * [1,9]
     * [1,2]
     * [1,2,7]
     * [1,2,7,8]
     */
    public int lengthOfLIS2(int[] nums) {
        int[] minVal = new int[nums.length];
        int idx = 0;
        for (int num : nums) {
            // 插入 minVal 对应位置
            // 二分查找 [left...right)
            int left = 0, right = idx;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (minVal[mid] < num) left = mid + 1;
                else right = mid;
            }
            // left 为 num 应当插入的位置
            minVal[left] = num;
            // 大于最大值
            if (left == idx) idx++;
        }
        return idx;
    }
}
