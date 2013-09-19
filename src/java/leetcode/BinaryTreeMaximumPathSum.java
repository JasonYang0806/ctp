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
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] max = {Integer.MIN_VALUE};
        _maxPathSum(root, max);
        return max[0];
    }
    
    private int _maxPathSum(TreeNode root, int[] max){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            max[0] = Math.max(max[0], root.val);
            return root.val;
        }
        int left = _maxPathSum(root.left, max);
        int right = _maxPathSum(root.right, max);
        if(left < 0 && right < 0){
            max[0] = Math.max(max[0], root.val);
            return root.val;
        }else if(left < 0){
            max[0] = Math.max(max[0], right + root.val);
            return right + root.val;
        }else if(right < 0){
            max[0] = Math.max(max[0], left + root.val);
            return left + root.val;
        }else{
            max[0] = Math.max(max[0], left + right + root.val);
            return root.val + Math.max(left, right);
        }
    }
}