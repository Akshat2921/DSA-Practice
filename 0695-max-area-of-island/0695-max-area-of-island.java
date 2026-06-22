class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int maxArea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) {
                    int area=dfs(grid,row,col,i,j);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid,int m,int n,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0; //mark as visited

        return 1+dfs(grid,m,n,i-1,j)+dfs(grid,m,n,i,j-1)+dfs(grid,m,n,i+1,j)+dfs(grid,m,n,i,j+1);
    }
}