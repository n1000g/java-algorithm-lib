package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *      dfs
 *
 * n=0      return
 * n=1      ()
 * n=2      (
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int left, int right, StringBuilder stringBuilder, List<String> res) {
        if (right == 0) {
            res.add(stringBuilder.toString());
        }
        if (left > 0) {
            stringBuilder.append('(');
            dfs(left - 1, right, stringBuilder, res);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
        if (right > left) {
            stringBuilder.append(')');
            dfs(left, right - 1, stringBuilder, res);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
    }
}
