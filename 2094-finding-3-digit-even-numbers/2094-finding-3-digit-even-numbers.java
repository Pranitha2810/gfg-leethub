class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> st = new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++)
        {
            if(digits[i]==0) continue;
            for(int j=0;j<n;j++)
            {
                if(i == j)continue;
                for(int k=0;k<n;k++)
                {
                    if(j == k || i == k) continue;
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if((num & 1)==0)
                    {
                       st.add(num);
                    }
                } 
            }
        }
        List<Integer> list = new ArrayList<>(st);
        int len = list.size();
        int[] res = new int[len];
        for(int i=0;i<len;i++)
        {
            res[i]=list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}