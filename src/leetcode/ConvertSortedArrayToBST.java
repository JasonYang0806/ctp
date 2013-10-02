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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null) return null;
        return _sortedArrayToBST(num, 0, num.length - 1);
    }
    
    private TreeNode _sortedArrayToBST(int[] num, int low, int high){
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = _sortedArrayToBST(num, low, mid - 1);
        root.right = _sortedArrayToBST(num, mid + 1, high);
        return root;
    }
}