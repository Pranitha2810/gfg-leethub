class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long mx = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    mx=Math.max(mx,(long)(nums[i]-nums[j])*nums[k]);
                }
            }
        }
        return mx;
    }
}