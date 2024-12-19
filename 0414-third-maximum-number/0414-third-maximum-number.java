class Solution {
    public int thirdMax(int[] nums) {
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        int mn=0;
        for(int v:nums)
        {
            if(v==Integer.MIN_VALUE)
                mn=1;
            if(v>first)
            {
                third=second;
                second=first;
                first=v;
            }
            else if(v>second && v<first)
            {
                third=second;
                second=v;
            }
            else if(v>third && v<second && v<first)
            {
                third=v;
            }
        }
        if(nums.length<3)
        {
            return first;
        }
        if(third == Integer.MIN_VALUE)
        {
            if(mn==1 && second != Integer.MIN_VALUE && third != Integer.MIN_VALUE)
                return third;
            else
                return first;
        }
        return third;
    }
}