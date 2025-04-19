class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res=0;
        for(int i=0;i<nums.length;i++)
        {
            int x=lower-nums[i];
            int y=upper-nums[i];
            int ind1=findCeil(x,nums,i);
            int ind2=findFloor(y,nums,i);
            if (ind1 != -1 && ind2 != -1 && ind2 >= ind1) {
                res += (ind2 - ind1 + 1);
            }
        }
        return res;
    }
    static int findCeil(int x,int[] nums,int i)
    {
        int low=i+1;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int findFloor(int y,int[] nums,int i)
    {
        int low=i+1;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<=y)
            {
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}