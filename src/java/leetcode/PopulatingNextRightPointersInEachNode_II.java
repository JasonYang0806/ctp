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

        while(head != null){
        	_head = head;
        	while(_head != null){
        		if(_head.next != null){
        			if(_head.left != null){
        				_head.left.next = _head.right != null ? _head.right : 
        								  _head.next.left != null ? _head.next.left :
        								  _head.next.right != null ? _head.next.right : findNextHead(_head.next);
        			}
        			if(_head.right != null){
        				_head.right.next = _head.next.left != null ? _head.next.left :
        								   _head.next.right != null ? _head.next.right : findNextHead(_head.next);
        			}
        		}else{
        			if(_head.left != null){
        				_head.left.next = (_head.right != null ? _head.right : null);
        			}
        		}
        		_head = head.next;
        	}
        	head = findNextHead(head);
        }
    }

    private TreeLinkNode findNextHead(TreeLinkNode oldHead){
    	while(oldHead.left == null && oldHead.right == null && oldHead.next != null){
    		oldHead = oldHead.next;
    	}
    	if(oldHead.left != null){
    		return oldHead.left;
    	}else if(oldHead.right != null){
    		return oldHead.right;
    	}else{
    		return null;
    	}
    }
}