/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> resList = new ArrayList<TreeNode>();
        TreeNode root = null;
        if(n == 0){
            resList.add(root);
            return resList;
        }
        
        return _generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> _generateTrees(int low, int high){
        if(low > high){
            return null;
        }
        
        ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
        
        if(low == high){
            treeList.add(new TreeNode(low));
            return treeList;
        }
        int i = low;
        TreeNode root;
        ArrayList<TreeNode> leftTrees = new ArrayList<TreeNode>();
        ArrayList<TreeNode> rightTrees = new ArrayList<TreeNode>();
        while(i <= high){
            leftTrees = _generateTrees(low, i - 1);
            rightTrees = _generateTrees(i + 1, high);
            if(leftTrees == null && rightTrees == null){
                root = new TreeNode(i);
                treeList.add(root);
            }else if(leftTrees != null && rightTrees == null){
                for(TreeNode leftNode : leftTrees){
                    root = new TreeNode(i);
                    root.left = leftNode;
                    treeList.add(root);
                }
            }else if(rightTrees != null && leftTrees == null){
                for(TreeNode rightNode : rightTrees){
                    root = new TreeNode(i);
                    root.right = rightNode;
                    treeList.add(root);
                }
            }else{
                for(TreeNode leftNode : leftTrees){
                    for(TreeNode rightNode : rightTrees){
                        root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        treeList.add(root);
                    }
                }
            } 
            i++;
        }
        return treeList;
    }
}