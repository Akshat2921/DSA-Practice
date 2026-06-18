class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        // boolean[] visited=new boolean[n];
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0],b=prerequisites[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        //Kahn's Algorithm
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) queue.offer(i);
            // visited[i]=true;
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans.add(node);
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.offer(neigh);
                    // visited[neigh]=true;
                }
            }
        }
        return ans.size()==n;
    }
}