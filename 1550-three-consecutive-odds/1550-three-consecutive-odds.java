class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        int i=0;
        while(i<arr.length)
        {
            if((arr[i] & 1)==0)
            {
                count=0;
            }
            else
            {
                count++;
            }
            i++;
            if(count>=3)
                return true;
        }
        return false;
    }
}