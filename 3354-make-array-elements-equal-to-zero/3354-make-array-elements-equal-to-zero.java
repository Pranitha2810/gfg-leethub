class Solution {
    public int countValidSelections(int[] nums) {
        int ans=0;
        int[] presum=new int[nums.length];
        presum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            presum[i]=presum[i-1]+nums[i];
        }
        for(int val : nums)
        {
            if(val != 0)
            {
                continue;
            }
            int leftsum = presum[i];
            int rightsum = presum[n-1]-leftsum;
            if(leftsum == rightsum)
                ans+=2;
            if(Math.abs(leftsum-rightsum)==1)
                ans+=1;
        }
        return ans;
    }
}