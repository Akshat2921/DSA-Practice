class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
        }
         for(String eq:equations){
            if(eq.charAt(1)=='='){
                int x=eq.charAt(0)-'a';
                int y=eq.charAt(3)-'a';
                union(x,y);
            }
         }
         for(String eq:equations){
            if(eq.charAt(1)=='!'){
                int x=eq.charAt(0)-'a';
                int y=eq.charAt(3)-'a';
                if(find(x)==find(y)) return false;
            }
         }
         return true;
    }
    private void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            parent[px]=py;
        }
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]); //Path compression
        }
        return parent[x];
    }
}