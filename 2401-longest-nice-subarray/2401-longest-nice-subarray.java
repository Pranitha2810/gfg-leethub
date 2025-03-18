class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max_len = 0;
        int l = 0;
        int or = 0;
        
        for (int r = 0; r < nums.length; r++) {
            while ((or & nums[r]) != 0) { 
                or ^= nums[l];
                l++;
            }
            or ^= nums[r];
            max_len = Math.max(max_len, r - l + 1);
        }
        
        return max_len;
    }
}
