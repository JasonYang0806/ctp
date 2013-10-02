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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        
        ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        
        parent.add(root);
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        int level = 1;
        
        while(!parent.isEmpty()){
            tmpList = new ArrayList<Integer>();
            for(TreeNode node : parent){
                if(level % 2 == 1){
                    tmpList.add(node.val);
                }else{
                    tmpList.add(0, node.val);
                }
                if(node.left != null) children.add(node.left);
                if(node.right != null) children.add(node.right);
            }
            res.add(tmpList);
            parent = children;
            children = new ArrayList<TreeNode>();
            level++;
        }
        return res;
    }
}