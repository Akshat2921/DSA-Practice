class Solution {
    int row_length,column_length,word_length;
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        row_length=board.length;
        column_length=board[0].length;
        word_length=word.length();

        for(int i=0;i<row_length;i++){
            for(int j=0;j<column_length;j++){
                if(board[i][j]==word.charAt(0) && find(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board,int i,int j,String word,int idx){
        if(idx>=word_length) return true;

        if(i<0 || i>=row_length || j<0 || j>=column_length || board[i][j]!=word.charAt(idx)){
            return false;
        }

        char temp=board[i][j];
        board[i][j]='$';

        for(int[] dir:directions){
            int i_=i+dir[0];
            int j_=j+dir[1];

            if(find(board,i_,j_,word,idx+1)) return true;
        }
        board[i][j]=temp;
        return false;
    }
}