class Solution {
    public String reversePrefix(String word, char ch) {
        int n=word.length();
        Stack<Character> st = new Stack<>();
        boolean found=false;
        int i=0;
        for(i=0;i<n;i++)
        {
            char letter = word.charAt(i);
            st.push(letter);
            if(ch==letter)
            {
                found=true;
                break;
            }
        }
        String ans="";
        if(found)
        {
            while(!st.isEmpty())
            {
                ans=ans+st.pop();
            }
            for(int j=i+1;j<n;j++)
            {
                ans=ans+word.charAt(j);
            }
            return ans;
        }
        return word;

    }
}