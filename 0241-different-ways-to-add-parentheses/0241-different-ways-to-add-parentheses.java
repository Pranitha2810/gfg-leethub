class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }
    private List<Integer> solve(String s)
    {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*')
            {
                List<Integer> left_result = solve(s.substring(0,i));
                List<Integer> right_result =solve(s.substring(i+1));
                for(int x:left_result)
                {
                    for(int y:right_result)
                    {
                        if(s.charAt(i)=='+')
                        {
                            result.add(x+y);
                        }
                        else if(s.charAt(i)=='-')
                        {
                            result.add(x-y);
                        }
                        else
                        {
                            result.add(x*y);
                        }
                    }
                }
            }
        }
        if(result.size()==0)
        {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
