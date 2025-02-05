class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        HashSet<Character> st = new HashSet<>();
        for(char ch: s2.toCharArray())
        {
            st.add(ch);
        }
        for(char ch: s1.toCharArray())
        {
            if(st.contains(ch))
                st.remove(ch);
        }
        if(st.size()==0)
        {
            int count=0,j=0;
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)!=s2.charAt(j))
                {
                    count++;
                }
                j++;
            }
            if(count==0 || count==2)
            {
                return true;
            }
            return false;
        }
        return false;

    }
}