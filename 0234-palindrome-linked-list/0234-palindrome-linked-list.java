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
    public boolean isPalindrome(ListNode head) {
        //find middle node of ll
        if(head==null || head.next==null)
            return true;
        ListNode slow=head,fast=head;
        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhead=Reverse(slow.next);
        ListNode temp1=head;
        ListNode temp2=secondhead;
        while(temp2 != null)
        {
            if(temp1.val != temp2.val)
            {
                Reverse(slow.next);
                return false;
            }
            temp2=temp2.next;
            temp1=temp1.next;
        }
        Reverse(slow.next);
        return true;
    }
    static ListNode Reverse(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode newhead=Reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newhead;
    }
}