//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int l=1,h=n,m=0;
        while(l<=h)
        {
            m=l+(h-l)/2;
            if(m*m <=n)
            {
                l=m+1;
            }
            else
                h=m-1;
        }
        return h;
    }
}
