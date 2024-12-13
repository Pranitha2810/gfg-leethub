//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        // code here
        int[] ans= new int[2];
        ans[0]=Floor(arr,x);
        ans[1]=Ceil(arr,x);
        return ans;
    }
    static int Floor(int[] a, int x)
    {
        int l=0,h=a.length-1,m=0;
        int ans=-1;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(a[m]<=x)
            {
                ans=a[m];
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return ans;
    }
    static int Ceil(int[]a,int x)
    {
        int l=0,h=a.length-1,m=0;
        int ans=-1;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(a[m]>=x)
            {
                ans=a[m];
                h=m-1;
            }
            else
            {
                l=m+1;
            }
        }
        return ans;
    }
}
