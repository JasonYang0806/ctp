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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return _sumNumbers(root, 0);
    }
    
    private int _sumNumbers(TreeNode root, int sum)
    {   
        int _sum = 0;
        
        if(root == null)
        {
            return 0;
        }
        
        if(root.left == null && root.right == null)
        {
            return 10 * sum + root.val;
        }
        
        if(root.left != null)
        {
            _sum += _sumNumbers(root.left, 10 * sum + root.val);
        }
        
        if(root.right != null)
        {
            _sum += _sumNumbers(root.right, 10 * sum + root.val);
        }
        
        return _sum;
    }
}