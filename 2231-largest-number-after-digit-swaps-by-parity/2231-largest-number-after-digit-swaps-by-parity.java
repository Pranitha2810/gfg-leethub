class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();
        int[] arr=numberToArray(num,p1,p2);
        int ans=0;
        int x=1;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]%2==0)
            {
                ans+=(p1.remove()*x);
            }
            else
            {
                ans+=(p2.remove()*x);
            }
            x=x*10;
        }
        return ans;
    }
    static int[] numberToArray(int num,PriorityQueue<Integer> p1,PriorityQueue<Integer> p2)
    {
        int n=String.valueOf(num).length();
        int[] arr = new int[n];
        int i=n-1;
        while(num>0)
        {
            arr[i--]=num%10;
            if((num%10)%2==0)
                p1.add(num%10);
            else
                p2.add(num%10);
            num=num/10;
        }
        return arr;
    }
}