class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int curColor = image[sr][sc];

        if (curColor == color)
            return image;

        boolean[][] visited = new boolean[rows][cols];

        dfs(image, sr, sc, color, rows, cols, curColor, visited);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int rows, int cols, int curColor,
            boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (image[row][col] != curColor)
            return;
        if (visited[row][col])
            return;

        image[row][col] = color;
        visited[row][col] = true;

        dfs(image, row - 1, col, color, rows, cols, curColor, visited); 
        dfs(image, row + 1, col, color, rows, cols, curColor, visited);
        dfs(image, row, col - 1, color, rows, cols, curColor, visited);
        dfs(image, row, col + 1, color, rows, cols, curColor, visited);
    }
}