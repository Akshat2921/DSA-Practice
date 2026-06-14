class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;

       boolean[] visited=new boolean[n];
       int count=0;
       for(int i=0;i<n;i++){
        if(visited[i]) continue;
        dfs(stones,i,visited,n);
        count++;
       }
       return n-count;
    }
    private void dfs(int[][] stones,int index,boolean[] visited,int n){
        visited[index]=true;

        for(int i=0;i<n;i++){
            if(!visited[i] && (
                stones[i][0] == stones[index][0] || stones[i][1]==stones[index][1])){
                    dfs(stones,i,visited,n);
                }
        }
    }
}