/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative version.
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resList = new ArrayList<Integer>();
        if(root == null) return resList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node, left, right;
        while(!stack.isEmpty()){
            node = stack.pop();
            left = node.left;
            right = node.right;
            
            if(left == null && right == null){
                resList.add(node.val);
            }
            if(right != null){
                stack.push(right);
            }
            if(left != null || right != null){
                stack.push(node);
            }
            if(left != null){
                stack.push(left);
            }
            node.left = null;
            node.right = null;
        }
        return resList;
    }
}

// Recursive version.
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