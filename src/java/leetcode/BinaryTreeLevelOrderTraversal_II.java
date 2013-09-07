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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> childQueue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            for(TreeNode node : queue){
                tmpList.add(node.val);
                if(node.left != null) childQueue.offer(node.left);
                if(node.right != null) childQueue.offer(node.right);
            }
            res.add(0, (ArrayList<Integer>)tmpList.clone());
            tmpList.clear();
            queue = childQueue;
            childQueue = new LinkedList<TreeNode>();
        }
        
        return res;
    }
    
}