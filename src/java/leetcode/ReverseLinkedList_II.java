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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null || m <= 0 || n <= 0 || m >= n){
            return head;
        }
        
        // 1. get the frontTail, run to m.
        ListNode frontTail = null;
        if(m > 1){
            frontTail = head;
            int frontTailIndex = 1;
            while(frontTail.next != null && frontTailIndex < m - 1){
                frontTail = frontTail.next;
                frontTailIndex++;
            }
            if(frontTail.next == null){
                return head;
            }
        }
        // 2. Run to n!
        ListNode preHead, pre, post;
        if(frontTail == null){
            preHead = head;
            pre = head;
        }else{
            preHead = frontTail.next;
            pre = frontTail.next;
        }
        post = pre.next;
        int index = m + 1;
        while(post != null && index <= n){
            pre.next = post.next;
            post.next = preHead;
            preHead = post;
            post = pre.next;
            index++;
        }
        if(frontTail == null){
            return preHead;
        }else{
            frontTail.next = preHead;
            return head;
        }
    }
}