class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(chars.indexOf(ch) != -1)
            {
                sum+=vals[chars.indexOf(ch)];
            }
            else
            {
                sum+=(int)(ch-'a');
                sum++;
            }
            if(sum<0)
                sum=0;
        }
        return sum;
    }
}