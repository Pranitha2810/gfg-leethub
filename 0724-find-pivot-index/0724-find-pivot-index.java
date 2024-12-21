class Solution {
    public int pivotIndex(int[] nums) {
        int[] presum=new int[nums.length];
        presum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            presum[i]=nums[i]+presum[i-1];
        }
        if(presum[presum.length-1]-presum[0]==0)
        {
            return 0;
        }
        for(int i=1;i<presum.length;i++)
        {
            if(presum[presum.length-1]-presum[i]==presum[i-1])
                return i;
        }
        return -1;
    }
}