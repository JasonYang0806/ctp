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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder == null || inorder == null) return null;
        return _buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode _buildTree(int[] preorder, int preStart, int preEnd, 
                                int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        int nodeVal = preorder[preStart];
        int inorderIndex = 0;
        // Find the nodeVal in inorder array, and becasue the values are all distinct, no other worries
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == nodeVal){
                inorderIndex = i;
                break;
            }
        }
        int leftTreeSize = inorderIndex - inStart;
        TreeNode root = new TreeNode(nodeVal);
        root.left = _buildTree( preorder, preStart + 1, preStart + leftTreeSize,
                                inorder, inStart, inorderIndex - 1);
        root.right = _buildTree(preorder, preStart + leftTreeSize + 1, preEnd,
                                inorder, inorderIndex + 1, inEnd);
        return root;
    }
}