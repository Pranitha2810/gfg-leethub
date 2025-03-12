class Solution {
    public int maximumCount(int[] nums) {
        int pos=FirstOccurancepositive(nums);
        int neg=LastOccuranceonegitive(nums);
        return Math.max(pos,neg);
    }
    public static int FirstOccurancepositive(int[]a)
    {
        int low=0,high=a.length-1,mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(a[mid]<=0)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        } 
        return a.length-low;
    }
    public static int LastOccuranceonegitive(int[] a)
    {
        int low=0,high=a.length-1,mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(a[mid]>=0)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return high+1;
    }
}