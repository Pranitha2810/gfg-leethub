class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int j=0;
        if(n%2==1)
        {
            j++;
            n=n-1;
        }
        for(int i=1;i<=n/2;i++)
        {
            res[j++]=i;
            res[j++]=-1*i;
        }
        return res;
    }
}