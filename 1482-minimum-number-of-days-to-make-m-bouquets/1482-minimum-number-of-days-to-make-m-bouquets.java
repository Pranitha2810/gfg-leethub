class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long v=(long)m*(long)k;
        if(v>bloomDay.length)
        {
            return -1;
        }
        int low=minimum(bloomDay),high=maximum(bloomDay);
        int mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(isPossible(bloomDay,m,k,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int[]a,int m,int k,int days)
    {
        int count=0,Bouquets=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<=days)
            {
                count++;
            }
            else
            {
                Bouquets+=(count/k);
                count=0;
            }
        }
        Bouquets+=(count/k);
        if(Bouquets>=m)
            return true;
        return false;
    }
    public static int minimum(int[]a)
    {
        int ans=a[0];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<ans)
            {
                ans=a[i];
            }
        }
        return ans;
    }
    public static int maximum(int[]a)
    {
        int ans=a[0];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>ans)
            {
                ans=a[i];
            }
        }
        return ans;
    }
}