class Solution {
    int m, n;
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;

        int[][] result=new int[m][n];
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    result[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
                else {
                    result[i][j]=-1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int i=cell[0];
            int j=cell[1];

            for(int[] dir:directions){
                int new_i=i+dir[0];
                int new_j=j+dir[1];
                if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && result[new_i][new_j]==-1){
                    result[new_i][new_j]=result[i][j]+1;
                    queue.add(new int[]{new_i,new_j});
                }
            }
        }
        return result;
    }
}