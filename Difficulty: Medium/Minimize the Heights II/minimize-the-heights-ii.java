// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
       int n=arr.length;
       if(n==1) return 0;
       Arrays.sort(arr);
       int mini=arr[0];
       int maxi=arr[n-1];
       int res=maxi-mini;
       for(int i=1;i<n;i++)
       {
           if((arr[i]-k)<0) continue;
           int minH=Math.min(arr[0]+k,arr[i]-k);
           int maxH=Math.max(arr[n-1]-k,arr[i-1]+k);
           res=Math.min(res,maxH-minH);
       }
       return res;
    }
}
