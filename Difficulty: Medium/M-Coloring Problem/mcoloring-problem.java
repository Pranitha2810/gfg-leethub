class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        HashMap<Integer,List<Integer>> adjList=new HashMap<>();
        for (int i = 0; i < v; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u=edge[0];
            int V=edge[1];
            adjList.get(u).add(V);
            adjList.get(V).add(u);
        }
        int[] color=new int[v];
        return solve(adjList,color,0,m,v);
    }
    private boolean solve(HashMap<Integer,List<Integer>> adjList,int[] color,int node,int m,int v)
    {
        if(node==v) return true;
        for(int i=1;i<=m;i++)
        {
            if(isValid(adjList,color,node,i))
            {
                color[node]=i;
                if(solve(adjList,color,node+1,m,v)==true)
                    return true;
                color[node]=0;
            }
        }
        return false;
    }
    private boolean isValid(HashMap<Integer,List<Integer>> adjList,int[] color,int node,int col)
    {
        for(int x:adjList.get(node))
        {
            if(color[x]==col) return false;
        }
        return true;
    }
}