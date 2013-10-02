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
    public ListNode addTwoNumbersConstantSpace(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        int carry = 0;
        int tmpSum = 0;
        
        ListNode res = l1;
        
        while(l1.next != null && l2.next != null){
            tmpSum = (l1.val + l2.val + carry);
            carry = tmpSum / 10;
            l1.val = tmpSum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // 1. l1.next == null and l2.next == null;
        if(l1.next == null && l2.next == null){
            tmpSum = l1.val + l2.val + carry;
            carry = tmpSum / 10;
            l1.val = tmpSum % 10;
            
            if(carry == 1){
                l1.next = new ListNode(carry);
            }
        }
        // 2. l1.next == null;
        else if(l1.next == null){
            tmpSum = l1.val + l2.val + carry;
            carry = tmpSum / 10;
            l1.val = tmpSum % 10;
            l1.next = l2.next;
            l1 = l1.next;
            _assistantConstantSpace(l1, carry);
        }
        // 3. l2.next == null
        else if(l2.next == null){
            tmpSum = l1.val + l2.val + carry;
            carry = tmpSum / 10;
            l1.val = tmpSum % 10;
            l1 = l1.next;
            _assistantConstantSpace(l1, carry);
        }
        return res;
    }
    
    private void _assistantConstantSpace(ListNode l, int carry){
        int tmpSum = 0;
        while(l.next != null && carry == 1){
            tmpSum = l.val + carry;
            carry = tmpSum / 10;
            l.val = tmpSum % 10;
            l = l.next;
        }
        if(carry != 0){
            tmpSum = l.val + carry;
            carry = tmpSum / 10;
            l.val = tmpSum % 10;
            if(carry == 1){
                l.next = new ListNode(carry);
            }
        }
    }

    public ListNode addTwoNumbersLinearSpace(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res = null, resTail = null;
        int carry = 0, tmpSum = 0, val;
     
        while(l1 != null || l2 != null || carry != 0){
            tmpSum = carry;
            if(l1 != null){
                tmpSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                tmpSum += l2.val;
                l2 = l2.next;
            }
            carry = tmpSum / 10;
            val = tmpSum % 10;
            if(res == null){
                res = resTail = new ListNode(val);
            }else{
                resTail.next = new ListNode(val);
                resTail = resTail.next;
            }
        }
        return res;
    }
}