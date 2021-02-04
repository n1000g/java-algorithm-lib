package leetcode;

import java.util.Arrays;

/**
 * 岛屿数量
 *
 * m == m
 * n == grid[i].length
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        NumIslandsDisjSets disjSets = new NumIslandsDisjSets(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i + 1 < m && grid[i + 1][j] == '1')
                        disjSets.union(i * n + j, (i + 1) * n + j);
                    // if (i - 1 > -1 && grid[i - 1][j] == '1')
                    //     disjSets.union(i * n + j, (i - 1) * n + j);
                    if (j + 1 < n && grid[i][j + 1] == '1')
                        disjSets.union(i * n + j, i * n + j + 1);
                    // if (j - 1 > -1 && grid[i][j - 1] == '1')
                    //     disjSets.union(i * n + j, i * n + j - 1);
                }
            }
        }
        return disjSets.count;
    }
}

class NumIslandsDisjSets {
    int[] id;
    int[] rank;
    int count;

    public NumIslandsDisjSets(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.count = 0;
        this.id = new int[m * n];
        this.rank = new int[m * n];
        Arrays.fill(this.id, -1);
        Arrays.fill(this.rank, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    this.count ++;
                    this.id[i * n + j] = i * n + j;
                }
            }
        }

    }
    public int find(int e) {
        while (e != id[e]) {
            id[e] = id[id[e]];
            e = id[e];
        }
        return e;
    }

    public void union(int p, int q) {
        int rootQ = find(q), rootP = find(p);
        if (rootQ == rootP) return;
        if (rank[rootP] > rank[rootQ]) {
            id[find(rootQ)] = find(rootP);
            rank[rootP] += rank[rootQ];
        } else {
            id[rootP] = find(rootQ);
            rank[rootQ] += rank[rootP];
        }
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
