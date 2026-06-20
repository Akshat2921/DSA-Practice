class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int d=curr[1];

            if(d>dist[node]) continue;

            for(int[] neighbour:adj.get(node)){
                int next=neighbour[0];
                int weight=neighbour[1];

                if(dist[node]+weight<dist[next]){
                    dist[next]=dist[node]+weight;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}