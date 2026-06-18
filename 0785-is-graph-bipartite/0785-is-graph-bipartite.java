class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1 && !dfs(graph,color,i,0))
            return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] color,int node,int c){
        color[node]=c;

        for(int neigh:graph[node]){
            if(color[neigh]==-1){
                if(!dfs(graph,color,neigh,1-c)) return false;
            }
            else if(color[neigh]==c) return false;
        }
        return true;
    }
}