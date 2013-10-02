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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Base cases:
        if(head == null || k <= 1) return head;
        
        ListNode preTail = null, cur = head, post = head, _head = head, _tail = head;
        while(cur != null){
            // Find the right position for "_tail"
            int count = 1;
            while(_tail != null && count < k){
                _tail = _tail.next;
                count++;
            }
            if(_tail == null){
                break;
            }else{
                post = cur.next;
                while(_head != _tail){
                    cur.next = post.next;
                    post.next = _head;
                    _head = post;
                    post = cur.next;
                }
                if(preTail != null){
                    preTail.next = _head;
                }else{
                    head = _head;
                }
                preTail = cur;
                cur = cur.next;
                _head = cur;
                _tail = cur;
            }
        }
        return head;
    }
}