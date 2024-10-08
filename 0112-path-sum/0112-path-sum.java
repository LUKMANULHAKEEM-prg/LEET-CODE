/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean traversal(TreeNode root,int sum,int target){
        if(root==null)return false;
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==target)return true;
        }
        return traversal(root.left,sum,target) || traversal(root.right,sum,target);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //int sum[]=new int [1];
        return traversal(root,0,targetSum);
    }
}