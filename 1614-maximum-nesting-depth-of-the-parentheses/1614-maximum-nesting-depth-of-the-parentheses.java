class Solution {
    public int maxDepth(String s) {
        int mx_ans=0;
        int count=0;
        int n=s.length();
        Stack<Character> st =  new Stack<>();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                count++;
                st.push('(');
            }
            else if(ch==')')
            {
                mx_ans=Math.max(count,mx_ans);
                st.pop();
                count--;
            }

        }
        return mx_ans;
        
    }
}