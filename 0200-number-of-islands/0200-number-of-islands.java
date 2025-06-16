class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Fix: check visited[i][j] == 0 and grid[i][j] == '1' (as grid is char[][])
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, n, m, visited, grid);
                }
            }
        }

        return ans;
    }

    private void bfs(int r, int c, int n, int m, int[][] visited, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = 1;
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] a = q.remove();
            int i = a[0];
            int j = a[1];

            for (int k = 0; k < 4; k++) {
                int newi = i + di[k];
                int newj = j + dj[k];

                if (newi >= 0 && newi < n && newj >= 0 && newj < m
                        && visited[newi][newj] == 0 && grid[newi][newj] == '1') {
                    visited[newi][newj] = 1;
                    q.add(new int[]{newi, newj});
                }
            }
        }
    }

    static int[] di = {-1, 0, +1, 0};
    static int[] dj = {0, +1, 0, -1};
}
