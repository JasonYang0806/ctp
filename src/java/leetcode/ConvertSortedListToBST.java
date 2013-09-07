/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode prePtr = null, ptr = head, fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            prePtr = ptr;
            ptr = ptr.next;
            fastPtr = fastPtr.next.next;
        }
        
        TreeNode root = new TreeNode(ptr.val);
        if(prePtr != null){
            prePtr.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(ptr.next);
        return root;
    }
}