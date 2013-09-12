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

// Fake Node: it works!!!!!!
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        fake.next = head;
        head = fake;
        
        ListNode pre = head, cur = head.next, nxt;
        while(cur != null && cur.next != null){
            while(cur.next != null && cur.val != cur.next.val){
                pre = cur;
                cur = cur.next;
            }
            if(cur.next != null){
                nxt = cur.next;
                while(nxt != null && nxt.val == cur.val) nxt = nxt.next;
                pre.next = nxt;
                cur = nxt;
            }
        }
        return head.next;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        // For head duplicates
        ListNode headPtr = head, headNextPtr = head.next;
        while(headPtr != null && headNextPtr != null && headPtr.val == headNextPtr.val){
            while(headNextPtr != null && headPtr.val == headNextPtr.val){
                headNextPtr = headNextPtr.next;
            }
            if(headNextPtr == null) return null;
            else{
                headPtr = headNextPtr;
                headNextPtr = headPtr.next;
            }
        }
        // First if is redundancy?
        if(headPtr == null){
            return null;
        }else if(headNextPtr == null){
            return headPtr;
        }
        
        head = headPtr;
        ListNode prePtr = head, ptr = head.next, nextPtr = head.next.next;
        while(ptr != null && ptr.next != null){
            while(ptr.next != null && ptr.val != ptr.next.val){
                prePtr = ptr;
                ptr = ptr.next;
            }
            if(ptr.next == null) return head;
            else{
                nextPtr = ptr.next;
                while(nextPtr != null && ptr.val == nextPtr.val){
                    nextPtr = nextPtr.next;
                }
                if(nextPtr == null){
                    prePtr.next = null;
                    return head;
                }else{
                    prePtr.next = nextPtr;
                    ptr = nextPtr;
                }
            }
        }
        return head;
    }
}