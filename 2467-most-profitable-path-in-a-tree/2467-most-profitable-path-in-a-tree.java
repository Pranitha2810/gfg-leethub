class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            tree.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        int[] bobTime = new int[n];
        Arrays.fill(bobTime,Integer.MAX_VALUE);
        dfsBob(tree,bob,-1,0,bobTime);
        return dfsAlice(tree,0,-1,0,0,amount,bobTime);
    }
    static boolean dfsBob(List<List<Integer>> tree,int node,int parent,int time,int[] bobTime)
    {
        if(node==0)
            return true;
        bobTime[node]=time;
        for(int neighbor : tree.get(node))
        {
            if(neighbor!=parent && dfsBob(tree,neighbor,node,time+1,bobTime))
            {
                return true;
            }
        }
        bobTime[node]=Integer.MAX_VALUE;
        return false;
    }
    static int dfsAlice(List<List<Integer>> tree,int node,int parent,int income,int time,int[] amount,int[] bobTime)
    {
        if(time<bobTime[node])
        {
            income+=amount[node];
        }
        else if(time==bobTime[node])
        {
            income+=amount[node]/2;
        }
        int maxinc=Integer.MIN_VALUE;
        boolean isLeaf = true;
        for(int neighbor : tree.get(node))
        {
            if(neighbor != parent)
            {
                isLeaf=false;
                maxinc = Math.max(maxinc,dfsAlice(tree,neighbor,node,income,time+1,amount,bobTime));
            }
        }
        return isLeaf ? income : maxinc;

    }
}