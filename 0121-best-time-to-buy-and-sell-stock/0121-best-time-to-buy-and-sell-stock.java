class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,mn=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            int cost = prices[i]-mn;
            profit=Math.max(profit,cost);
            mn=Math.min(mn,prices[i]);
        }
        return profit;
    }
}