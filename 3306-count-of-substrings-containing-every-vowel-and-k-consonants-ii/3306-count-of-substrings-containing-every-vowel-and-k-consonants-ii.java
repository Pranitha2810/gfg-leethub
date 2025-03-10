class Solution {
    public long countOfSubstrings(String word, int k) {
      int n=word.length();
      int[] next_consonant = new int[n];
      nextConsonant(next_consonant,n,word);
      int l=0,r=0,p=-1,c=0;
      HashMap<Character,Integer> mp = new HashMap<>();
      long count=0;
      while(r<n)
      {
            if(p != r)
            {
                if(isVowel(word.charAt(r))) mp.put(word.charAt(r),1+mp.getOrDefault(word.charAt(r),0));
                else c++;
                p=r;
            }
            if(r>=(5+k-1))
            {
                if(mp.size()==5 && c==k)
                {
                    count+=next_consonant[r]-r;
                }
                if((mp.size()==5 && c==k) || c>k)
                {
                    if(isVowel(word.charAt(l)))
                    {
                        mp.put(word.charAt(l),mp.get(word.charAt(l))-1);
                        if(mp.get(word.charAt(l))==0)
                        {
                            mp.remove(word.charAt(l));
                        }
                    }
                    else
                    {
                        c--;
                    }
                    l++;
                }
                else
                {
                    r++;
                }
            }
            else
                r++;
      }
      return count;

    }
    static void nextConsonant(int[] nc,int n,String s)
    {
        int next=n;
        for(int i=n-1;i>=0;i--)
        {
            nc[i]=next;
            if(!isVowel(s.charAt(i)))
                next=i;
        }
    }
    static boolean isVowel(char ch)
    {
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}