class Solution {
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int numComp = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            else {
                numComp++;
                visited[i] = true;
                dfs(adj, i);
            }
        }

        return numComp;
    }

    private void dfs(List<List<Integer>> adj, int i) {
        for(int nei : adj.get(i)) {
            if(visited[nei]) {
                continue;
            } else {
                visited[nei] = true;
                dfs(adj, nei);
            }
        }
    }
}
