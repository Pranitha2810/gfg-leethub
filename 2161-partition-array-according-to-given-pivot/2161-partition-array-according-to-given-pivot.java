class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> great = new ArrayList<>();
        for(int n :nums)
        {
            if(n<pivot)
                less.add(n);
            else if(n==pivot)
                equal.add(n);
            else
                great.add(n);
        }
        int i=0;
        int j=0;
        while(j<less.size())
        {
            nums[i]=less.get(j);
            i++;
            j++;
        }
        j=0;
        while(j<equal.size())
        {
            nums[i]=equal.get(j);
            i++;
            j++;
        }
        j=0;
        while(j<great.size())
        {
            nums[i]=great.get(j);
            i++;
            j++;
        }
        return nums;
        
    }
}