class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] v= new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        v[0]=1;
        while(!q.isEmpty())
        {
            int node=q.remove();
            ans.add(node);
            for(int n : adj.get(node))
            {
                if(v[n]==0)
                {
                    q.add(n);
                    v[n]=1;
                }
            }
        }
        return ans;
    }
}