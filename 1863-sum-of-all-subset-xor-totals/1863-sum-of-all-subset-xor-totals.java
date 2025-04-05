class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = subset(nums,0,0,0);
        return sum;
    }
    static int subset(int[] nums,int i,int sum,int xor)
    {
        if(i==nums.length)
        {
            sum+=xor;
            return sum;
        }
        xor^=nums[i];
        sum=subset(nums,i+1,sum,xor);
        xor^=nums[i];
        sum=subset(nums,i+1,sum,xor);
        return sum;
    }
}