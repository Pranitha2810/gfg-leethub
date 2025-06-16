class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int mini=nums[0];
        for(int j=1;j<nums.length;j++)
        {
            if(nums[j]>mini)
                ans=Math.max(ans,nums[j]-mini);
            mini=Math.min(mini,nums[j]);
        }
        return ans;
    }
}