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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = length(head);
        if(len == 0){
            return head;
        }
        n = n % len;
        if(n <= 0){
            return head;
        }
        ListNode slow = head, fast = head;
        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
    
    private int length(ListNode head){
        ListNode iterator = head;
        int len = 0;
        while(iterator != null){
            iterator = iterator.next;
            len++;
        }
        return len;
    }
}