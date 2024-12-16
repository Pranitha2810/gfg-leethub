/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1==null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        ListNode dummy = new ListNode(-1);
        ListNode current =dummy;
        while(temp1 != null || temp2 != null || carry ==1)
        {
            int sum=carry;
            if(temp1 != null)
                sum+=temp1.val;
            if(temp2 != null)
                sum+=temp2.val;
            current.next=new ListNode(sum%10);
            carry=sum/10;
            current=current.next;
            if(temp1 != null)
                temp1=temp1.next;
            if(temp2 != null)
                temp2=temp2.next;
        }
        if(carry==1)
        {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}