/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Running Time: O(n)
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return;
        }
        _flatten(root);
    }
    
    private TreeNode _flatten(TreeNode root){
        // Base case
        if(root.left == null && root.right == null){
            return root;
        }
        
        if(root.left == null){
            return _flatten(root.right);
        }
        if(root.right == null){
            root.right = root.left;
            root.left = null;
            return _flatten(root.right);
        }
        TreeNode leftTail = _flatten(root.left);
        TreeNode rightTail = _flatten(root.right);
        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
        return rightTail;
    }
}

// Running time: O(n^2)
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null || (root.left == null && root.right == null)) return;
        
        flatten(root.left);
        flatten(root.right);
        
        // Get the tail of left subtree.
        if(root.left == null) return;
        
        TreeNode leftTail = root.left;
        while(leftTail.right != null){
            leftTail = leftTail.right;
        }
        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
    }   
}