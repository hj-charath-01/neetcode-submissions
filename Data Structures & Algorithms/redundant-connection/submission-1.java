class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            if(dfs(adj, edge[0], edge[1], new HashSet<>())) {
                return edge;
            }
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);                       
        }

        return new int[]{};
    }

    private boolean dfs(List<List<Integer>> adj, int source, int dest, Set<Integer> seen) {
        if(seen.contains(source)) return false;
        seen.add(source);
        for(int nei : adj.get(source)) {
            if (nei == dest) {
                return true;
            }
            if (dfs(adj, nei, dest, seen)) {
                return true;
            }
        }

        return false;
    }
}
