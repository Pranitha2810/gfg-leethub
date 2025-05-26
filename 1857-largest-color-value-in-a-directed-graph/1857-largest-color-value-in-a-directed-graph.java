class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        // Build the graph and indegree array
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Queue for Kahn's algorithm (topological sort)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // DP array: dp[node][color] = max frequency of this color at node
        int[][] dp = new int[n][26];
        int max = 0;
        int visited = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;

            int colorIdx = colors.charAt(u) - 'a';
            dp[u][colorIdx]++;
            max = Math.max(max, dp[u][colorIdx]);

            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        return visited == n ? max : -1;  // if cycle exists, not all nodes are visited
    }
}
