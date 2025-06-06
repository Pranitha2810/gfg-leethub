class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n=nums.length;
        int[] visited = new int[n];
        helper(nums,0,ans,ds,visited);
        return ans;
    }
    private void helper(int[] nums,int ind,List<List<Integer>> ans,List<Integer> ds,int[] visited)
    {
        if(ind==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]==0)
            {
                ds.add(nums[i]);
                visited[i]=1;
                helper(nums,ind+1,ans,ds,visited);
                ds.remove(ds.size()-1);
                visited[i]=0;
            }
        }
    }
}