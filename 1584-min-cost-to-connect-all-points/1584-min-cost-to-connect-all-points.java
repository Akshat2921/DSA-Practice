class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<int[]> edges=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        Collections.sort(edges,(a,b)-> a[2]-b[2]);

        DSU dsu=new DSU(n);
        int cost=0;

        for(int[] edge:edges){
            if(dsu.union(edge[0],edge[1])){
                cost+=edge[2];
            }
        }
        return cost;
    }
    class DSU{
        int[] parent,rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        boolean union(int x,int y){
            int px=find(x);
            int py=find(y);

            if(px==py) return false;
            if(rank[py]<rank[px]){
                parent[py]=px;
            }else if(rank[px]<rank[py]){
                parent[px]=py;
            }else{
                parent[py]=px;
                rank[px]++;
            }
            return true;
        }
        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}