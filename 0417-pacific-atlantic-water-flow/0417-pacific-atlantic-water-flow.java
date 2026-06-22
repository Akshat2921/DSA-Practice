import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific (top + left borders)
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, heights[i][0]);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, heights[0][j]);

        // DFS from Atlantic (bottom + right borders)
        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);

        // Collect cells reachable by both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    // Helper DFS
    private void dfs(int[][] h, boolean[][] vis, int r, int c, int prevHeight) {
        int m = h.length, n = h[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || h[r][c] < prevHeight) return;

        vis[r][c] = true;

        dfs(h, vis, r + 1, c, h[r][c]);
        dfs(h, vis, r - 1, c, h[r][c]);
        dfs(h, vis, r, c + 1, h[r][c]);
        dfs(h, vis, r, c - 1, h[r][c]);
    }
}
