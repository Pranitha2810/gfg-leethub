class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        //tabulation
        HashSet<Integer> s = new HashSet<>();
        for(int x:arr)
        {
            s.add(x);
        }
        int res=0;
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int prev=arr[i];
                int cur=arr[j];
                int next_element=prev+cur;
                int len=2;
                while(s.contains(next_element))
                {
                    len++;
                    prev=cur;
                    cur=next_element;
                    next_element=prev+cur;
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
}