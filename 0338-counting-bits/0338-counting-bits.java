class Solution {
    public int[] countBits(int n) {
       int[] res = new int[n+1];
       res[0]=0;
       for(int i=1;i<=n;i++) 
       {
            if((i&1)==1) res[i]=res[i/2]+1;
            else res[i]=res[i/2];
       }
       return res;
    }
}