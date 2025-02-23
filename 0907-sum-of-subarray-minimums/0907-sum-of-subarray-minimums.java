class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = NSE(arr);
        int[] psee = PSEE(arr);
        int n=arr.length;
        int mod=1000000007;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            int left = i-psee[i];
            int right=nse[i]-i;
            sum=(sum+((long)left*right*arr[i])%mod)%mod;
        }
        return (int)sum;
    }
    static int[] NSE(int[] a)
    {
        Stack<Integer> st = new Stack<>();
        int n=a.length;
        int nse[] = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && a[st.peek()]>a[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    static int[] PSEE(int[] a)
    {
        Stack<Integer> st = new Stack<>();
        int n=a.length;
        int[] psee = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && a[st.peek()]>=a[i])
            {
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
}