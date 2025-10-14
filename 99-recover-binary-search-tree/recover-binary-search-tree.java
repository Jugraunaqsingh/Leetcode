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
    TreeNode one;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        check(root);
        int x=one.val;
        one.val=second.val;
        second.val=x;

    }
    public void check(TreeNode root){
        if(root==null) return;
        check(root.left);
        if(prev!=null && prev.val>root.val){
            if(one==null){
                one=prev;
            }
            second=root;
        }
        prev=root;
        check(root.right);
    }
}