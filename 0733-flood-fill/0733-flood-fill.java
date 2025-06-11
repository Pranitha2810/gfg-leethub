class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial_color = image[sr][sc];
        if (initial_color == color) return image;
        int n = image.length;
        int m = image[0].length;
        dfs(sr, sc, n, m, image, color, initial_color);
        return image;
    }

    private void dfs(int r, int c, int n, int m, int[][] image, int new_color, int old_color) {
        image[r][c] = new_color;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == old_color) {
                dfs(nr, nc, n, m, image, new_color, old_color);
            }
        }
    }
}
