/** leetcode 101
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
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p!=null && q == null || p==null && q!=null || p.val != q.val){
            return false;
        }

        return (isSame(p.left,q.right) & isSame(p.right, q.left));
    }
    public boolean isSymmetric(TreeNode root) {
        // maybe check if sametree with left and right alternatively?
        //edge case 
        if(root.left == null && root.right == null){
            return true;
        }

        TreeNode p = root.left;
        TreeNode q = root.right;

        return isSame(p,q);
    }
}
