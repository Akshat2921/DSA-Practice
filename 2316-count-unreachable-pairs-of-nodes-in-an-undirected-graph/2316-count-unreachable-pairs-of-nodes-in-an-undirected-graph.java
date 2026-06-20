class Solution {
      int[] parent;
      int[] rank;
    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        //Build Components
        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }

        //Counting Component sizes
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int root=findParent(i);
            map.put(root,map.getOrDefault(root,0)+1);
        }

        long result=0;
        long remainingNodes=n;

        for(int size:map.values()){
            result+=(long) size*(remainingNodes-size);
            remainingNodes-=size;
        }
        return result;
    }
    private void union(int x,int y){
        int x_parent=findParent(x);
        int y_parent=findParent(y);

        if(x_parent==y_parent) return;

        if(rank[x_parent]<rank[y_parent]){
            parent[x_parent]=y_parent;
        }
        else if(rank[y_parent]<rank[x_parent]){
            parent[y_parent]=x_parent;
        }
        else{
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }
    private int findParent(int x){
        if(parent[x]!=x){
            parent[x]=findParent(parent[x]);
        }
        return parent[x];
    }
}