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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        
        ListNode cur = head, nxt = head.next;
        while(nxt != null){
            while(nxt != null && cur.val != nxt.val){
                cur = nxt;
                nxt = nxt.next;
            }
            while(nxt != null && cur.val == nxt.val) nxt = nxt.next;
            cur.next = nxt;
        }
        return head;
    }
}