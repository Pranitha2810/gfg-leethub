//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int l=1,h=m,mid=0;
        while(l<=h)
        {
            mid=l+(h-l)/2;
            int midN = func(n,m,mid);
            if(midN==1) return mid;
            if(midN==0) l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
    public static int func(int n,int m,int mid)
    {
        int ans=1;
        for(int i=1;i<=n;i++)
        {
            ans=ans*mid;
        }
        if(ans==m)
            return 1;
        if(ans>m) return 2;
        return 0;
    }
}