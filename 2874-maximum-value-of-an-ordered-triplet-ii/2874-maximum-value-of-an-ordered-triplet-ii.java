class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int ans=0;
        int[] right_max = new int[n];
        int rm=nums[n-1];
        for(int i=n-2;i>=1;i--)
        {
            right_max[i]=rm;
            rm=Math.max(rm,nums[i]);
        }
        int left_max=nums[0];
        for(int i=1;i<n-1;i++)
        {
            ans=Math.max(ans,(left_max-nums[i])*right_max[i]);
            left_max=Math.max(left_max,nums[i]);
        }
        return ans;
    }
}