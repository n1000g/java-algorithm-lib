package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 *
 *      建立字典树
 *      dfs board
 *      剪枝
 */
public class Solution212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        if (words == null || words.length == 0) return res;
        // 建立字典树
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        // dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, "", res);
            }
        }
        return res;
    }

    /**
     * board[i][j] 处字符 ch
     *           在 node 树中不为 end     str += ch
     *           在 node 树中且为 end     添加 res
     *           不在树中                下一节点
     */
    private void dfs(char[][] board, Trie node, int i, int j, String str, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || node == null) return;
        char ch = board[i][j];
        if (ch == '.') return;
        str += ch;
        node = node.getNext()[ch - 'a'];
        if (node != null && node.isEnd()) {
            res.add(str);
            node.setEnd(false);
        }
        board[i][j] = '.';
        dfs(board, node, i - 1, j, str, res);
        dfs(board, node, i + 1, j, str, res);
        dfs(board, node, i, j - 1, str, res);
        dfs(board, node, i, j + 1, str, res);
        board[i][j] = ch;
    }
}

class Trie {
    private Trie[] next;
    private boolean end;

    public Trie() {
        this.end = false;
        this.next = new Trie[26];
    }

    public void insert(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        Trie node = this;
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) node.next[ch - 'a'] = new Trie();
            node = node.next[ch - 'a'];
        }
        node.end = true;
    }

    public Trie[] getNext() {
        return next;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
