class Solution {
    public long distributeCandies(int n, int limit) {
        long ways=0;
        int minch1=Math.max(0,n-2*limit);
        int maxch1=Math.min(n,limit);
        for(int i=minch1;i<=maxch1;i++)
        {
            int N=n-i; // for ch2 and ch3
            int minch2=Math.max(0,N-limit);
            int maxch2=Math.min(N,limit);
            ways+=maxch2-minch2+1;
        }
        return ways;
    }
}