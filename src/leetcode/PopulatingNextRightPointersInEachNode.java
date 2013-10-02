/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
        	return;
        }

        TreeLinkNode head = root;
        TreeLinkNode _head = head;

        // Because this is a full tree. 
        while(head.left != null){
        	_head = head;
        	while(_head != null){
        		_head.left.next = _head.right;
        		if(_head.next != null){
        			_head.right.next = _head.next.left;
        		}
        		_head = _head.next;
        	}
        	head = head.left;
        }
    }
}