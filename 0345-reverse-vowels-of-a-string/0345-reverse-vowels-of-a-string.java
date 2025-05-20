class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        int i=0,j=n-1;
        char[] arr = s.toCharArray();
        while(i<j)
        {
            char ch1=arr[i];
            char ch2=arr[j];
            if(!isVowel(ch1))
            {
                i++;
                continue;
            }
            if(!isVowel(ch2))
            {
                j--;
                continue;
            }
            char temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    private boolean isVowel(char ch)
    {
        ch=Character.toLowerCase(ch);
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
}