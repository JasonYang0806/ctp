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