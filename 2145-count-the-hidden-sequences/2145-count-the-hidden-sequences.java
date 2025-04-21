class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int cur=0;
        int minVal=0;
        int maxVal=0;
        for(int x:differences)
        {
            cur=cur+x;
            minVal=Math.min(minVal,cur);
            maxVal=Math.max(maxVal,cur);
            if(((upper-maxVal)-(lower-minVal)+1)<=0)
                return 0;
        }
        return (upper-maxVal)-(lower-minVal)+1;
    }
}