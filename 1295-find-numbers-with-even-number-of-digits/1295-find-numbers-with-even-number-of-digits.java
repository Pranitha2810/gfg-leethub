class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int val : nums)
        {
            String s= String.valueOf(val);
            if(s.length()%2==0)
                count++;
        }
        return count;
    }
}