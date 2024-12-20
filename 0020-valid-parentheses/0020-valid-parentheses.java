class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            {
                s1.push(s.charAt(i));
            }
            else
            {
                if(s1.isEmpty())
                    return false;
                char ch=s1.pop();
                if((s.charAt(i)==')' && ch=='(') || (s.charAt(i)==']' && ch=='[') || (s.charAt(i)=='}' && ch=='{'))
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        return s1.isEmpty();
    }
}