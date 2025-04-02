class Solution {
    public long maximumTripletValue(int[] nums) {
        long max_triplet = 0;
        long max_left=0;
        long max_diff=0;
        for(int i=0;i<nums.length;i++)
        {
            max_triplet=Math.max(max_triplet,(long)(max_diff*nums[i]));
            max_diff = Math.max(max_diff,(long)(max_left-nums[i]));
            max_left=Math.max(max_left,nums[i]);
        }
        return max_triplet;
    }
}