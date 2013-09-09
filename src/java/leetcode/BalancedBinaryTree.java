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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        res = _isBalanced(root);
        return res[0] == 1 ? true : false;
    }
    
    // return type integer array: size == 2
    // first: 1: stands for it's balanced, 0: stands for it's not balanced.
    // second: stands for the height of the tree.
    private int[] _isBalanced(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            res[0] = 1;
            res[1] = 0;
            return res;
        }
        
        int[] left = new int[2];
        int[] right = new int[2];
        left = _isBalanced(root.left);
        right = _isBalanced(root.right);
        
        
        if(Math.abs(left[1] - right[1]) > 1){
            res[0] = 0;
        }else{
            res[0] = left[0] & right[0];
        }
        res[1] = Math.max(left[1], right[1]) + 1;
        return res;
    }
}