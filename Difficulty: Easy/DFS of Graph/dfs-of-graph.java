class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] v = new int[adj.size()];
        dfss(0,ans,v,adj);
        return ans;
    }
    private void dfss(int node,ArrayList<Integer> ans,int[] v,ArrayList<ArrayList<Integer>> adj)
    {
        v[node]=1;
        ans.add(node);
        for(int n : adj.get(node))
        {
            if(v[n]==0)
                dfss(n,ans,v,adj);
        }
    }
}