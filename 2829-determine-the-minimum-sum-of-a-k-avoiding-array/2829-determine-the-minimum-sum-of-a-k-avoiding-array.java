class Solution {
    public int minimumSum(int n, int k) {
        int sum=0;
        HashSet<Integer> st = new HashSet<>();
        for(int i=1;i<=n;i++)
        {
            if(st.contains(k-i))
            {
                n++;
                continue;
            }
            sum+=i;
            st.add(i);
        }
        return sum;
    }
}