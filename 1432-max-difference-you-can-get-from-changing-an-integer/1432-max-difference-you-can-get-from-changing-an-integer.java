class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        char ch1='#';
        char ch2='#';
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='9')
            {
                ch1=str.charAt(i);
                break;
            }
        }
        boolean one=false;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(i==0 && c!='1')
            {
                ch2=c;
                one=true;
                break;
            }
            else if(c!='0' && c!=str.charAt(0))
            {
                ch2=c;
                one=false;
                break;
            }
        }
        String s1=str.replace(ch1,'9');
        String s2="";
        if(one==true)
        {
            s2=str.replace(ch2,'1');
        }
        else
        {
            s2=str.replace(ch2,'0');
        }
        int a=Integer.parseInt(s1);
        int b=Integer.valueOf(s2);
        int ans=a-b;
        return ans;
    }
}