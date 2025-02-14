class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            int rob=nums[i];
            if(i>1)
                rob+=dp[i-2];
            int notrob=0+dp[i-1];
            dp[i]=Math.max(rob,notrob);
        }
        return dp[n-1];
    }
    //memozation
    // static int memo(int i,int[] nums,int[] dp)
    // {
    //     if(i==0) return nums[0];
    //     if(i<0) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     int rob = nums[i]+memo(i-2,nums,dp);
    //     int notrob = 0+memo(i-1,nums,dp);
    //     return dp[i]=Math.max(rob,notrob);
    // }
}