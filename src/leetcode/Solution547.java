package leetcode;

import java.util.Arrays;

/**
 * 547
 */
public class Solution547 {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 ||
                isConnected[0].length == 0)
            return 0;
        FindCircleNumDisjSets disjSets = new FindCircleNumDisjSets(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                // System.out.println(Arrays.toString(disjSets.id));
                if (isConnected[i][j] > 0 && !disjSets.isConnected(i, j)) disjSets.union(j, i);
            }
        }
        return disjSets.count;
    }
}
class FindCircleNumDisjSets {

    int[] id;
    int[] rank;
    int count;

    public FindCircleNumDisjSets(int n) {
        this.id = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.id[i] = i;
            this.rank[i] = 1;
        }
        this.count = n;
    }

    // O(1)
    public void union(int p, int q) {
        if (isConnected(p, q)) return;
        if (rank[p] < rank[q]) {
            // q 深
            for (int i = 0; i < id.length; i++) {
                if (id[i] == id[p]) {
                    id[i] = id[q];
                }
            }
            rank[q] += rank[p];
        } else {
            // p 深
            for (int i = 0; i < id.length; i++) {
                if (id[i] == id[q]) {
                    id[i] = id[p];
                }
            }
            rank[p] += rank[q];
        }
        count --;
    }

    // O(N)
    public int find(int e) {
        return id[e];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
