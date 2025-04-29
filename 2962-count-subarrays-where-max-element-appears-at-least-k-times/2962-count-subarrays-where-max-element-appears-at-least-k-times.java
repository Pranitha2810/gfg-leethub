class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        int i=0,j=0;
        int n=nums.length;
        int maxi=maximum(nums);
        int count=0;
        while(j<n)
        {
            if(nums[j]==maxi)
            {
                count++;
                while(count>=k)
                {
                    ans+=(n-j);
                    if(nums[i]==maxi)
                    {
                        count--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
    static int maximum(int[] nums)
    {
        int maxi=0;
        for(int x:nums)
        {
            maxi=Math.max(maxi,x);
        }
        return maxi;

    }
}