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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
       if(head==null)
       {
            return null;
       }  
       if(head.next==null)
       {
            return new TreeNode(head.val);
       }
       ListNode slow=middleOfLL(head);
       TreeNode root = new TreeNode(slow.val); 
       ListNode head1=head;
       ListNode head2=slow.next;
       ListNode temp=head1;
       if(temp != null)
       {
            while(temp.next != slow)
            {
                temp=temp.next;
            }
            temp.next=null;
       }
       root.left=sortedListToBST(head1);
       root.right=sortedListToBST(head2);
       return root;
    }
    static ListNode middleOfLL(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}