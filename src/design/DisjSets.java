package design;

import java.util.Arrays;

/**
 * Disjoint set class, using union by rank and path compression.
 * Elements in the set are numbered starting at 0.
 * @author Mark Allen Weiss
 */
public class DisjSets {
    private int[] s;

    public DisjSets(int n) {
        this.s = new int[n];
        Arrays.fill(s, -1);
    }

    /**
     * assume root1 and root2 are distinct
     */
    public void union(int p, int q) {
        if (s[q] < s[p]) {
            s[p] = q;
        } else {
            if (s[p] == s[q]) s[p] --;
            s[q] = p;
        }
    }

    public int find(int e) {
        if(s[e] < 0) {
            return e;
        }
        else return s[e] = find(s[e]);
    }
}
