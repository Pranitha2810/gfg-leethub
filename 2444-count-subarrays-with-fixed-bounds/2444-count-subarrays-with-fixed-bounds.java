class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
       long count=0;
       int mink_index=-1,maxk_index=-1,invalid_index=-1;
       for(int i=0;i<nums.length;i++)
       {
            if(nums[i]>maxK || nums[i]<minK)
                invalid_index=i;
            if(nums[i]==maxK) maxk_index=i;
            if(nums[i]==minK) mink_index=i;
            count+=Math.max(Math.min(mink_index,maxk_index)-invalid_index,0);
       }
       return count;
    }
}