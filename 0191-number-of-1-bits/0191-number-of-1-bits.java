class Solution {
    public int hammingWeight(int n) {
        //approch 1
        int ans=0;
        for(int i=0;i<32;i++)
        {
            if((n&1)==1) ans++;
            n=n>>1;
        }
        return ans;
    }
}