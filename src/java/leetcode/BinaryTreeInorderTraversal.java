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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        _inorderTraversal(nodeList, root);
        return nodeList;
    }
    
    private void _inorderTraversal(ArrayList<Integer> nodeList, TreeNode root){
        if(root == null) return;
        
        _inorderTraversal(nodeList, root.left);
        nodeList.add(root.val);
        _inorderTraversal(nodeList, root.right);
    }
}