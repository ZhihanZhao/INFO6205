package edu.neu.coe.info6205.union_find;

public class WQU_Alter {
    private final int[] parent;
    private final int[] depth;
    private int count;

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public WQU_Alter(int n) {
        count = n;
        parent = new int[n];
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            depth[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public int components() {
        return count;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    private void updateParent(int p, int x) {
        parent[p] = x;
    }


    public int find(int p) {
        validate(p);
        int root = p;
        while (this.parent[root] != root){
            root = parent[root];
        }
        return root;
    }

    public void union(int i, int j) {
        if(find(i) == find(j)){
            return;
        }

        if( depth[i]<depth[j]){
            updateParent(i,j);
        }else if(depth[i] == depth[j]){
            updateParent(i,j);
            depth[j] += 1;
        }else{
            updateParent(j,i);
        }
        count--;
    }
}
