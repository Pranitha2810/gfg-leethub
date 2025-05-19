class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max_len=1;
        int len=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                len++;
            }
            else
            {
                max_len=Math.max(max_len,len);
                len=1;
            }
        }
        return max_len;
    }
}