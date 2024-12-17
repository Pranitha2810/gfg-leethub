class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length; 
        int[] result=new int[n];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                int index=i+nums[i];
                while(index >=n)
                {
                    index = index%n;
                }
                result[i]=nums[index];
            }
            else if(nums[i]==0)
            {
                result[i]=nums[i];
            }
            else
            {
                int index = i-Math.abs(nums[i]);
                while(index < 0 || index >n)
                {
                    index=Math.abs(index)%n;
                    index=n-index;
                }
                result[i]=nums[index];
            }
        }
        return result;
    }
}