class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max_ans=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            max_ans=Math.max(max_ans,Math.abs(nums[i]-nums[i+1]));
        }
        max_ans=Math.max(max_ans,Math.abs(nums[n-1]-nums[0]));
        return max_ans;
    }
}