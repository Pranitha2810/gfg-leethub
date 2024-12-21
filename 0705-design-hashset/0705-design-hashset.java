class MyHashSet {
    int val;
    MyHashSet next;
    public MyHashSet() {
        
    }
    public MyHashSet(int val)
    {
        this.val=val;
        this.next=null;
    }
    public MyHashSet(int val, MyHashSet next)
    {
        this.val=val;
        this.next=next;
    }
    MyHashSet head=null;
    public void add(int key) {
        if(head==null)
        {
            MyHashSet nn= new MyHashSet(key);
            head=nn;
        }
        else
        {
           boolean present=false;
           MyHashSet temp=head;
           while(temp != null)
           {
             if(temp.val == key)
             {
                present=true;
                break;
             }
             temp=temp.next;
           } 
           if(present==false)
           {
                MyHashSet nn= new MyHashSet(key);
                temp=head;
                while(temp.next != null)
                {
                    temp=temp.next;
                }
                temp.next=nn;
           }
        }
    }
    
    public void remove(int key) {
        if(head==null)
            return;
        if(head.val == key)
            head=head.next;
        MyHashSet prev=null;
        MyHashSet temp=head;
        while(temp != null)
        {
            if(temp.val == key)
            {
                prev.next=prev.next.next;
            }
            else
            {
                prev=temp;
            }
            temp=temp.next;
        }
    }
    
    public boolean contains(int key) {
        if(head==null)
            return false;
        MyHashSet temp = head;
        while(temp != null)
        {
            if(temp.val == key)
                return true;
            temp=temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */