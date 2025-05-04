class Solution {
    public int divide(int dividend, int divisor) {
    if(dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
    if(divisor == 1)
        return dividend;
    if(divisor == -1)
        return -dividend;
    if(dividend==divisor) return 1;
    boolean sign=true; //+ve
    if(dividend>=0 && divisor<0)
        sign=false;
    if(dividend<0 && divisor>0)
        sign=false;
    long n = Math.abs((long) dividend);
    long d = Math.abs((long) divisor);
    int ans=0;
    while(n>=d)
    {
        int cnt=0;
        while(n>=(d<<(cnt+1)))
        {
            cnt++;
        }
        ans+=(1<<cnt);
        n=n-(d*(1<<cnt));
    }
    if(ans>=Integer.MAX_VALUE && sign==true)
        return Integer.MAX_VALUE;
    if(ans>=Integer.MAX_VALUE && sign == false)
        return Integer.MIN_VALUE;
    return sign ? ans : -1*ans;
    }
}