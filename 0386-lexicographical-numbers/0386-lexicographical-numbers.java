class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int num=1;num<10;num++)
        {
            solve(num,n,ans);
        }
        return ans;
    }
    private void solve(int curr,int n,List<Integer> ans)
    {
        if(curr>n) return;
        ans.add(curr);
        for(int append=0;append<=9;append++)
        {
            int new_num=curr*10 + append;
            solve(new_num,n,ans);
        }
    }
}