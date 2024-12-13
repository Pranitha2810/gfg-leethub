//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int count=0;
        int first=FirstOccurance(arr,target);
        if(first==-1)
        {
            return count;
        }
        int last=LastOccurance(arr,target);
        count=last-first+1;
        return count;
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
