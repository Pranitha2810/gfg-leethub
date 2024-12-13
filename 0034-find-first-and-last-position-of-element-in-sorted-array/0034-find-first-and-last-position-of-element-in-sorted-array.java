class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans= new int[2];
        int first=FirstOccurance(nums,target);
        if(first==-1)
        {
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int last=LastOccurance(nums,target);
        ans[0]=first;
        ans[1]=last;
        return ans;
    }
    static int FirstOccurance(int[]a,int x)
    {
        int l=0,h=a.length-1,m=0;
        int f=-1;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(a[m]==x)
            {
                f=m;
                h=m-1;
            }
            else if(a[m]<x)
            {
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return f;
    }
    static int LastOccurance(int[] a, int x)
    {
        int l=0,h=a.length-1,m=0;
        int last=-1;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(a[m]==x)
            {
                last=m;
                l=m+1;
            }
            else if(a[m]<x)
            {
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return last;
    }
}