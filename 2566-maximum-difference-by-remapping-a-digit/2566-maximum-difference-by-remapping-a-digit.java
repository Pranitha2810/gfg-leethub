class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char firstNot_9 = '#';
        char firstNot_0 = '#';
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='9' && firstNot_9=='#')
            {
                firstNot_9=str.charAt(i);
            }
            else if(str.charAt(i)!='0' && firstNot_0=='#')
            {
                firstNot_0=str.charAt(i);
            }
            if(firstNot_9!='#' && firstNot_0!='#')
                break;
        }
        String s1=str.replace(firstNot_9,'9');
        String s2=str.replace(firstNot_0,'0');
        int result = Integer.parseInt(s1) - Integer.parseInt(s2);
        return result;
    }
}