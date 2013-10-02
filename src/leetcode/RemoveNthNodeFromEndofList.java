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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || n < 0) return null;
        if(n == 0) return head;
        
        ListNode slow = head, fast = head;
        // First, get make slow and fast pointer have n diffenence.
        while(fast.next != null && n > 0){
            fast = fast.next;
            n--;
        }
        if(fast.next == null){
            if(n == 0){
                slow.next = slow.next.next;
            }else if(n == 1){
                head = head.next;
            }
        }else{
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}