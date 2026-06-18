class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        int[][] directions = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        queue.offer(new int[] { 0, 0 });

        int distance = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                int row = curr[0];
                int col = curr[1];

                if (row == n - 1 && col == n - 1)
                    return distance;

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0
                            && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[] { nextRow, nextCol });
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}