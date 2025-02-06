class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int width=0,lines=1;
        for(char ch: s.toCharArray())
        {
            if((widths[ch-'a']+width)<=100)
            {
                width+=widths[ch-'a'];
            }
            else
            {
                lines++;
                width=widths[ch-'a'];
            }
        }
        int[] res = new int[2];
        res[0]=lines;
        res[1]=width;
        return res;
    }
}