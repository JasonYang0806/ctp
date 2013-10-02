/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
            return head;
        }
        
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode frontTail = fakeNode;
        while(frontTail.next != null && frontTail.next.val < x){
            frontTail = frontTail.next;
        }
        if(frontTail.next == null){
            return head;
        }
        ListNode pre = frontTail.next, cur = pre.next;
        while(cur != null){
            if(cur.val < x){
                pre.next = cur.next;
                cur.next = frontTail.next;
                frontTail.next = cur;
                if(frontTail == fakeNode){
                    head = cur;
                }
                frontTail = frontTail.next;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}