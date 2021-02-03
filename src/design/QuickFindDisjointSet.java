package design;

public class QuickFindDisjointSet extends DisjointSet {
    public QuickFindDisjointSet(int n) {
        super(n);
    }

    /**
     * O(1)
     */
    public int find(int e) {
        return id[e];
    }

    /**
     * O(n)
     */
    public void union(int p, int q) {
        if (find(p) == find(q)) return;
        if (rank[p] > rank[q]) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == find(q)) {
                    id[i] = find(p);
                }
            }
            rank[p] += rank[q];
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == find(p)) {
                    id[i] = find(q);
                }
            }
            rank[q] += rank[p];
        }
        count --;
    }
}
