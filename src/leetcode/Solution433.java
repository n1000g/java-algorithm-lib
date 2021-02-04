package leetcode;

import java.util.HashSet;

/**
 * 433. 最小基因变化
 *      start - end 的最小变化即 start 与 end 不同字符的位数
 *      深搜 + 剪枝
 *      AAA -> CCB  {AAB, AAC, ACC, CCB, CCA}
 *                  AAA
 *            CAA   ACA     AAC
 */
public class Solution433 {
    private int res = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        // 存储中间步骤
        HashSet<String> stepSet = new HashSet<>();
        dfs(start, end, bank, stepSet, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 遍历 bank 寻找当前步的下一步
     * 如果找到 end 则记录一个步数
     * 这个步数
     */
    private void dfs(String current, String end, String[] bank, HashSet<String> stepSet, int stepCount) {
        if (current.equals(end)) res = Math.min(res, stepCount);
        if (stepCount > res) return;
        for (String step : bank) {
            if (transferable(current, step) && !stepSet.contains(step)) {
                stepSet.add(step);
                dfs(step, end, bank, stepSet, stepCount + 1);
                stepSet.remove(step);
            }
        }
    }

    private boolean transferable(String current, String step) {
        int diff = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != step.charAt(i)) diff ++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
