class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        int i=0;
        int j=i+k-1;
        char[] arr = s.toCharArray();
        while(j<n)
        {
            reverse(arr,i,j);
            i=i+(2*k);
            j=i+k-1;
        }
        reverse(arr,i,j);
        return new String(arr);
    }
    private void reverse(char[] arr,int i,int j)
    {
        int n=arr.length;
        if(i<n && j<n)
        {
            while(i<j)
            {
                char temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                j--;
            }
        }
        if(i<n && j>=n)
        {
            j=n-1;
            while(i<j)
            {
                char temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                j--;
            }
        }

    }
}