class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(res,path,s,0);
        return res;
    }
    private void solve(List<List<String>> res,List<String> path,String s,int index)
    {
        if(index==s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrome(s,index,i))
            {
                path.add(s.substring(index,i+1));
                solve(res,path,s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}