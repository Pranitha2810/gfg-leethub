//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        if(head == null || head.next ==null)
            return head;
        Node zeroHead = new Node(-1);
        Node zero=zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead=new Node(-1);
        Node two=twoHead;
        Node temp=head;
        while(temp != null)
        {
            if(temp.data == 0)
            {
                zero.next=temp;
                zero=temp;
                temp=temp.next;
            }
            else if(temp.data == 1)
            {
                one.next=temp;
                one =temp;
                temp=temp.next;
            }
            else
            {
                two.next=temp;
                two=temp;
                temp=temp.next;
            }
        }
        if(oneHead.next == null)
        {
            zero.next=twoHead.next;
        }
        else
        {
            zero.next=oneHead.next;
        }
        one.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends