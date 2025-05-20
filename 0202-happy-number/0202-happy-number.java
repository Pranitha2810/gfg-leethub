class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        while(n!=1 && !st.contains(n))
        {
            st.add(n);
            n=getNextNumber(n);
        }
        return n==1;
    }
    private int getNextNumber(int n)
    {
        int sum=0;
        while(n>0)
        {
            int digit=n%10;
            sum+=digit*digit;
            n=n/10;
        }
        return sum;
    }
}