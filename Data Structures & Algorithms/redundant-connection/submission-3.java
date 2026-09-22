class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }   

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{};
    }

    private boolean union(int u, int v) {
        int p1 = findParent(u);
        int p2 = findParent(v);

        if(p1 == p2) {
            return false;
        }
        parent[p2] = p1;

        return true;
    }

    private int findParent(int u) {
        if(u == parent[u]) {
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }
}
