class Solution {
    public int minStartValue(int[] nums) {
        int[] presum=new int[nums.length];
        int mini=Integer.MAX_VALUE;
        presum[0]=nums[0];
        mini=Math.min(mini,presum[0]);
        for(int i=1;i<nums.length;i++)
        {
            presum[i]=nums[i]+presum[i-1];
            mini=Math.min(mini,presum[i]);
        }
        if(mini>0)
            return 1;
        return Math.abs(mini)+1;
    }
}