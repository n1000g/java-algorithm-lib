package design;

public class QuickUnionDisjointSet extends DisjointSet {
    public QuickUnionDisjointSet(int n) {
        super(n);
    }

    /**
     * O(N)
     * makes the height of the subset tree won't exceed 2
     */
    public int find(int e) {
        while (e != id[e]) {
            id[e] = id[id[e]];
            e = id[e];
        }
        return e;
    }

    /**
     * O(1)
     */
    public void union(int p, int q) {
        if (find(p) == find(q)) return;
        if (rank[p] > rank[q]) {
            id[q] = p;
            rank[p] += rank[q];
        } else {
            id[p] = q;
            rank[q] += rank[p];
        }
        count--;
    }
}
