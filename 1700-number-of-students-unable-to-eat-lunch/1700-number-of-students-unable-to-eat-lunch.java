class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int n1=students.length;
        int n2=sandwiches.length;
        for(int i=n2-1;i>=0;i--)
        {
            st.push(sandwiches[i]);
        }
        for(int i=0;i<n1;i++)
        {
            q.add(students[i]);
        }
        int ans=0;
        int res=0;
        while(!st.isEmpty() && !q.isEmpty())
        {
            int dead=0;
            while(q.peek() != st.peek())
            {
                dead++;
                int s=q.remove();
                q.offer(s);
                if(dead==q.size())
                {
                    res=n1-ans;
                    return res;
                }
            }
            q.remove();
            st.pop();
            ans++;
        }
        res=n1-ans;
        return res;
    }
}