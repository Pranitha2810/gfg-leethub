class Solution {
    int n;
    private void backT(int[] nums,List<Integer> sub,int ind,HashSet<List<Integer>> st)
    {
        if(ind==n)
        {
            if(sub.size()>=2)
            {
                st.add(new ArrayList<>(sub));
            }
            return ;
        }
        if(sub.size()==0 || nums[ind]>=sub.get(sub.size()-1))
        {
            sub.add(nums[ind]);
            backT(nums,sub,ind+1,st);
            sub.remove(sub.size()-1);
        }
        backT(nums,sub,ind+1,st);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> st = new HashSet<>();
        List<Integer> sub= new ArrayList<>();
        n=nums.length;
        backT(nums,sub,0,st);
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }
}