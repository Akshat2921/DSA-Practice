class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        boolean[][] visited=new boolean[rows][cols];
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,visited,rows,cols);
                    islands++;
                }
            }
        }

        return islands;
    }
    private void dfs(int i,int j,char[][] grid,boolean[][] visited,int rows,int cols){
        if(i<0 || i>=rows || j<0 || j>=cols) return;
        if(visited[i][j]) return;
        if(grid[i][j]=='0') return;

        visited[i][j]=true;

        dfs(i+1,j,grid,visited,rows,cols);
        dfs(i-1,j,grid,visited,rows,cols);
        dfs(i,j+1,grid,visited,rows,cols);
        dfs(i,j-1,grid,visited,rows,cols);
    }
}