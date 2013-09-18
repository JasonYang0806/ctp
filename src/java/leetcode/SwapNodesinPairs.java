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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
        	return head;
        }

        ListNode slow = head, fast = head.next, preTail = null;
        while(slow != null && fast != null){
        	slow.next = fast.next;
        	fast.next = slow;
        	if(preTail == null){
        		head = fast;
        	}else{
        		preTail.next = fast;
        	}
        	preTail = slow;
        	slow = slow.next;
        	if(slow != null){
        		fast = slow.next;
        	}
        }
        return head;
    }
}