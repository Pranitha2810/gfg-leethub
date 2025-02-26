class Solution {
    public int maxAbsoluteSum(int[] nums) {
       
        int maxSum=Math.max(Math.abs(maxNegitive(nums)),maxPositive(nums));
        return maxSum;
    }
    static int maxPositive(int[] nums)
    {
        int mx=Integer.MIN_VALUE;
        int sum=0;
        for(int x : nums)
        {
            sum+=x;
            mx=Math.max(mx,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return mx;
    }
    static int maxNegitive(int[] nums)
    {
        int mn=Integer.MAX_VALUE;
        int sum=0;
        for(int x : nums)
        {
            sum+=x;
            mn=Math.min(mn,sum);
            if(sum>0)
            {
                sum=0;
            }
        }
        return mn;
    }
}