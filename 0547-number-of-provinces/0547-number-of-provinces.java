class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        int n=isConnected.length;
        for(int i=1;i<n+1;i++)
        {
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adjList.get(i+1).add(j+1);
                    adjList.get(j+1).add(i+1);
                }
            }
        }
        int[] visited = new int[n+1];
        int count=0;
        for(int i=1;i<n+1;i++)
        {
            if(visited[i]==0)
            {
                count++;
                dfs(i,adjList,visited);
            }
        }
        return count;
    }
    private void dfs(int node,HashMap<Integer,List<Integer>> adjList,int[] visited)
    {
        visited[node]=1;
        for(int neighbor : adjList.get(node))
        {
            if(visited[neighbor] == 0)
            {
                dfs(neighbor,adjList,visited);
            }
        }
    }
}