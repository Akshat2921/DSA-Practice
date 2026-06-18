class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] edge:pre){
            int a=edge[0],b=edge[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) queue.add(i);
        }
        int[] ans=new int[n];
        int index=0;

        while(!queue.isEmpty()){
            int node=queue.poll();
            ans[index++]=node;
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0) queue.add(neigh);
            }
        }
        return index==n?ans:new int[0];
    }
}