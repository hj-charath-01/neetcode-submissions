class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        int[] order = new int[numCourses];
        int orderIdx = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] preReq : prerequisites) {
            indeg[preReq[0]]++;
            adj.get(preReq[1]).add(preReq[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            order[orderIdx++] = curr;  
            for(int nei : adj.get(curr)) {
                indeg[nei]--;
                if(indeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if(orderIdx == numCourses) {
            return order;
        } else {
            return new int[]{};
        }
    }
}
