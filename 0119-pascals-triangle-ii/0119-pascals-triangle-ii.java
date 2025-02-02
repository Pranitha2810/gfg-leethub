class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans= new ArrayList<>();
        ans.add(1);
        long x=1;
        for(int i=0;i<rowIndex;i++)
        {
            x*=(rowIndex-i);
            x/=(i+1);
            ans.add((int)x);
        }
        return ans;

    }
}