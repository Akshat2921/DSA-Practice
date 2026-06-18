class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(source);
        visited[source]=true;

        while(!queue.isEmpty()){
            int node=queue.poll();

            if(node==destination) return true;

            for(int neigh:graph.get(node)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    queue.offer(neigh);
                }
            }
        }
        return false;
    }
}