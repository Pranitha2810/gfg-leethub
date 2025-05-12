class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        HashMap<Integer,Integer> nge=new HashMap<>();
        nextGreaterElement(nums2,nge);
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=nge.get(nums1[i]);
        }
        return ans;
    }
    static void nextGreaterElement(int[] arr,HashMap<Integer,Integer> nge)
    {
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty()) nge.put(arr[i],-1);
            else nge.put(arr[i],st.peek());
            st.push(arr[i]);
        }
    }
}