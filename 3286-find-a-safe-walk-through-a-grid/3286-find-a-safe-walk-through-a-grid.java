class Solution {
    private static final int[][] dirs={
        {0,1},{1,0},{0,-1},{-1,0},
    };
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int[][] dist=new int[m][n];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.offerFirst(new int[]{0,0});
        dist[0][0]=grid.get(0).get(0);

        while(!q.isEmpty()){
            int[] cur=q.pollFirst();
            int cx=cur[0];
            int cy=cur[1];

            if(cx==m-1 && cy==n-1) return true;
           
            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int cost=dist[cx][cy]+grid.get(nx).get(ny);

                if(cost>=health) continue;

                if(cost<dist[nx][ny]){
                    dist[nx][ny]=cost;
                    if(grid.get(nx).get(ny)==0) q.offerFirst(new int[]{nx,ny});
                    else q.offerLast(new int[]{nx,ny});
                }
            }
        }

        return false;
    }
}