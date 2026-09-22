class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            indeg[prerequisite[1]]++;
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        int finished = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            finished++;

            for(int nei : adj.get(node)) {
                indeg[nei]--;
                if(indeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finished == numCourses;
    }
}
