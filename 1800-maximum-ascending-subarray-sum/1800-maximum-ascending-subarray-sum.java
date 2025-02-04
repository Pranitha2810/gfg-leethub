class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int maxsum=sum;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
                sum+=nums[i];
            else
            {
                maxsum= Math.max(maxsum,sum);
                sum=nums[i];
            }
        }
        maxsum=Math.max(maxsum,sum);
        return maxsum;
    }
}