class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        long minNuksaan =Integer.MAX_VALUE;
        int count=0;
        for(long num : nums)
        {
            if((num^k)>num)
            {
                count++;
                sum+=(num^k);
            }
            else
            {
                sum+=num;
            }
            minNuksaan = Math.min(minNuksaan,Math.abs(num-(num^k)));
        }
        if((count&1)==0) return sum;
        return sum-minNuksaan;
    }
}