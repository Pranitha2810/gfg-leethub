class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }
    static void MergeSort(int[] a,int low,int high)
    {
        if(low>=high)
            return;
        int mid=low+(high-low)/2;
        MergeSort(a,low,mid);
        MergeSort(a,mid+1,high);
        Merge(a,low,mid,high);
    }
    static void Merge(int[] a,int low,int mid,int high)
    {
        int[] temp=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int index=0;
        while(left<=mid && right<=high)
        {
            if(a[left]<=a[right])
            {
                temp[index++]=a[left];
                left++;
            }
            else
            {
                temp[index++]=a[right]; 
                right++;
            }
        }
        while(left<=mid)
        {
             temp[index++]=a[left];
             left++;
        }
        while(right<=high)
        {
             temp[index++]=a[right];
             right++;
        }
        for(int i=low;i<=high;i++)
        {
            a[i]=temp[i-low];
        }
    }
}