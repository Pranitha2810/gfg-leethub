class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> st=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++)
        {
            if(digits[i]==0) continue;
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                for(int k=0;k<n;k++)
                {
                    if(i==k || j==k) continue;
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if((num & 1)==0)
                        st.add(num);
                }
            }
        }
        int len=st.size();
        int[] ans = new int[len];
        int i=0;
        for(int x : st)
        {
            ans[i++]=x;
        }
        Arrays.sort(ans);
        return ans;
    }
}