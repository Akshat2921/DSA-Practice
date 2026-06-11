class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        boolean[][] visited=new boolean[rows][cols];
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(i,j,grid,visited,rows,cols);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(int i,int j,char[][] grid,boolean[][] visited,int rows,int cols){
        Queue<int[]> queue=new LinkedList<>();

        visited[i][j]=true;
        queue.offer(new int[]{i,j});

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] node=queue.poll();
            int row=node[0];
            int col=node[1];

            for(int[] dir:directions){
                int nextRow=row+dir[0];
                int nextCol=col+dir[1];

                if(nextRow<0 || nextCol<0 || nextRow>=rows || nextCol>=cols) continue;
                if(visited[nextRow][nextCol]) continue;
                if(grid[nextRow][nextCol]=='0') continue;

                visited[nextRow][nextCol]=true;
                queue.offer(new int[]{nextRow,nextCol});
            }
        }
    }
}