package design;

/**
 * 并查集 DisjointSet
 *      用于解决动态连通性一类问题
 *
 * 主要参考
 *      [https://www.jianshu.com/p/2cf91402ddac](https://www.jianshu.com/p/2cf91402ddac)
 */
public abstract class DisjointSet {
    protected int[] id;     // id[i] = parent of i
    protected byte[] rank;	// rank[i] = rank of subtree rooted at i (cannot be more than 31)
    protected int count;    // number of components

    public DisjointSet(int n) {
        this.id = new int[n];
        this.rank = new byte[n];
        for (int i = 0; i < n; i++) {
            this.id[i] = i;
            this.rank[i] = 1;
        }
        this.count = n;
    }

    public abstract int find(int e);
    public abstract void union(int p, int q);
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public int getCount() {
        return count;
    }
}
