class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q=new LinkedList<>();
    }
    
    public void push(int x) {
        int s=q.size();
        q.add(x);
        for(int i=1;i<=s;i++)
        {
            int y=q.remove();
            q.offer(y);
        }
    }
    
    public int pop() {
        if(q.isEmpty())
            return -1;
        int x=q.poll();
        return x;
    }
    
    public int top() {
        if(q.isEmpty())
            return -1;
        return q.peek();
        
    }
    
    public boolean empty() {
        if(q.isEmpty())
            return true;
        return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */