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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        _pathSum(root, pathList, path, sum);
        return pathList;
    }
    
    private void _pathSum(TreeNode root, ArrayList<ArrayList<Integer>> pathList, ArrayList<Integer> path, int sum){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            pathList.add((ArrayList<Integer>)path.clone());
        }
        _pathSum(root.left, pathList, path, sum - root.val);
        _pathSum(root.right, pathList, path, sum - root.val);
        
        path.remove(path.size() - 1);
    }
}