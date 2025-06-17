class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(bfs(i,graph,color)==false)
                    return false;
            }
        }
        return true;
    }
    private boolean bfs(int i,int[][] graph,int[] color)
    {
        color[i]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty())
        {
            int node = q.remove();
            for(int ngb : graph[node])
            {
                if(color[ngb]==-1)
                {
                    color[ngb] = color[node]==0 ? 1 :0;
                    q.add(ngb);
                }
                else if(color[node]==color[ngb])
                    return false;
            }
        }
        return true;
    }
}