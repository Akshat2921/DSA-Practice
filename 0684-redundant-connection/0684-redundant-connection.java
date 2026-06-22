class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(find(u)==find(v)) return edge; //Cyclic Edge found

            union(u,v);
        }
        return new int[]{};
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x,int y){
        int px=find(x);
        int py=find(y);

        if(px==py) return;

        if(rank[py]<rank[px]){
            parent[py]=px;
        }else if(rank[px]<rank[py]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
    }
}