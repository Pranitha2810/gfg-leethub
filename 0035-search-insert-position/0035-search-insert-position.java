class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,h=nums.length-1,m=0;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(nums[m]>=target)
            {
                h=m-1;
            }
            else
            {
                l=m+1;
            }
        }
        return l;
    }
}