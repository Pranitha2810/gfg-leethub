class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return memo(n-1,nums,dp);
    }
    static int memo(int i,int[] nums,int[] dp)
    {
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int rob = nums[i]+memo(i-2,nums,dp);
        int notrob = 0+memo(i-1,nums,dp);
        return dp[i]=Math.max(rob,notrob);
    }
}