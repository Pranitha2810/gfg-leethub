//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int i=0;
        Stack<String> st = new Stack<>();
        while(i<post_exp.length())
        {
            char c=post_exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                st.push(Character.toString(c));
            }
            else
            {
                String t1=st.pop();
                String t2 = st.pop();
                String new_val=Character.toString(c)+t2+t1;
                st.push(new_val);
            }
            i++;
        }
        return st.peek();
    }
}
