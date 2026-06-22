class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f: flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]}); 
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src,0});

        int stops=0;

        while(!queue.isEmpty() && stops<=k){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] cur=queue.poll();
                int node=cur[0];
                int cost=cur[1];

                for(int[] neigh:adj.get(node)){
                    int next=neigh[0];
                    int price=neigh[1];

                    if(cost+price<dist[next]){
                        dist[next]=cost+price;
                        queue.offer(new int[]{next,dist[next]});
                    }
                }
            }
            stops++;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}