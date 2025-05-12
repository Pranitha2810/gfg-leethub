public class DLLNode
{
    int key;
    int value;
    DLLNode prev;
    DLLNode next;
    public DLLNode(int key,int value)
    {
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    DLLNode head=new DLLNode(-1,-1);
    DLLNode tail = new DLLNode(-1,-1);
    Map<Integer,DLLNode> mp = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        DLLNode node = mp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key))
        {
            deleteNode(mp.get(key));
        }
        if(mp.size()==capacity)
        {
            deleteNode(tail.prev);
        }
        insertAfterHead(new DLLNode(key,value));
        
    }
    private void insertAfterHead(DLLNode node)
    {
        mp.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    private void deleteNode(DLLNode node)
    {
        mp.remove(node.key);
        DLLNode before=node.prev;
        DLLNode after=node.next;
        before.next=after;
        after.prev=before;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */