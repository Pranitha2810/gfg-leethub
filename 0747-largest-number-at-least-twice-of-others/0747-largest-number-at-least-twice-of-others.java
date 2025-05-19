class Solution {
    public int dominantIndex(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int second_largest=Integer.MIN_VALUE;
        int ind=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>largest)
            {
                second_largest=largest;
                largest=nums[i];
                ind=i;
            }
            else if(nums[i]>second_largest)
            {
                second_largest=nums[i];
            }
        }
        if(largest>=(2*second_largest))
            return ind;
        return -1;
    }
}