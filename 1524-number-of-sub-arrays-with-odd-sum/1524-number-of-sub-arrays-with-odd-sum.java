class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int evenCount = 1,oddCount=0;
        int sum=0,res=0;
        for(int x: arr)
        {
            sum+=x;
            if(sum%2==0)
            {
                res=(res+oddCount)%mod;
                evenCount++;
            }
            else
            {
                res=(res+evenCount)%mod;
                oddCount++;
            }
        }
        return res;
    }
}