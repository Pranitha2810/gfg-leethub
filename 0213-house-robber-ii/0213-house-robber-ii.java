class Solution {
    public int rob(int[] nums) {
        int[] arr1 = Arrays.copyOfRange(nums,1,nums.length);
        int[] arr2 = Arrays.copyOfRange(nums,0,nums.length-1);
        int m1 = Robbing(arr1);
        int m2 = Robbing(arr2);
        return Math.max(m1,m2);
    }
    static int Robbing(int[] nums)
    {
        int n=nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for(int i=1;i<n;i++)
        {
            int rob=nums[i];
            if(i>1)
                rob+=prev2;
            int notrob = 0+prev1;
            int cur=Math.max(rob,notrob);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}