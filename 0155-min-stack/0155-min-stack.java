class MinStack {
    Stack<Long> s;
    Long mini=Long.MAX_VALUE;
    public MinStack() {
       s=new Stack<>(); 
    }
    
    public void push(int value) {
        Long val=Long.valueOf(value);
        if(s.isEmpty())
        {
            s.push(val);
            mini=val;
        }
        else
        {
            if(val>mini)
                s.push(val);
            else
            {
                s.push(2*val-mini);
                mini=val;
            }
        }

    }
    
    public void pop() {
        if(s.isEmpty())
            return;
        Long x=s.pop();
        if(x<mini)
        {
            mini=2*mini-x;
        }
    }
    
    public int top() {
        if(s.isEmpty())
            return -1;
        Long x=s.peek();
        if(x<mini)
            return mini.intValue();
        return x.intValue();
        
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */