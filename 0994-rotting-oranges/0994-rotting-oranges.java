class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshCount=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0) return 0;

        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int time=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] current=queue.poll();
                int x=current[0];
                int y=current[1];

                for(int[] dir:directions){
                    int newX=dir[0]+x;
                    int newY=dir[1]+y;

                    if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]==1){
                        grid[newX][newY]=2;
                        queue.offer(new int[]{newX,newY});
                        freshCount--;
                    }
                }
            }
            time++;
        }
        return freshCount == 0?time-1:-1;
    }
}