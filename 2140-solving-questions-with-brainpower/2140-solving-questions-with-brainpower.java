class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return findProfit(0,questions,dp);
    }
    static int findProfit(int ind,int[][] questions,int[] dp)
    {
        if(ind >= questions.length)
            return 0;
        if(dp[ind] != -1) return dp[ind];
        int nottake = findProfit(ind+1,questions,dp);
        int take = questions[ind][0]+findProfit(ind+questions[ind][1]+1,questions,dp);
        return dp[ind]=Math.max(nottake,take);
    }
}