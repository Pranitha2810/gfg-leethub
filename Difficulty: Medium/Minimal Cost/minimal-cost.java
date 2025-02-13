import java.util.Arrays;
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n=arr.length;
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
        return memo(n-1,arr,k,dp);
    }
    static int memo(int ind,int[] arr,int k,int[] dp)
    {
        if(ind==0) return 0;
        if(dp[ind] != -1)  return dp[ind];
        int maxi = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++)
        {
            if((ind-j)>=0)
            {
                int jump= memo(ind-j,arr,k,dp)+Math.abs(arr[ind]-arr[ind-j]);
                maxi=Math.min(maxi,jump);
            }
        }
        return dp[ind]=maxi;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends