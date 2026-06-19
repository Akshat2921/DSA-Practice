class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            for(int v:graph[i]){
                adj.get(i).add(v);
            }
        }
       Queue<Integer> queue=new LinkedList<>();
       int[] indegree=new int[V];
       int count=0;

       for(int u=0;u<V;u++){
        for(int v:graph[u]){
            adj.get(v).add(u);
            indegree[u]++;
        }
       }
       for(int i=0;i<V;i++){
        if(indegree[i]==0){
            count++;
            queue.add(i);
        }
       }
       boolean[] safe = new boolean[V];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            safe[u] = true;

            for (int v : adj.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}