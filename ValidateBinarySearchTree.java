class Solution {
    public boolean valid(TreeNode node, long left, long right){
        // true case :  if null
        if(node == null) return true;

        // fasle case : !(true case on left && true case on right)
        if(!(node.val > left && node.val < right)){
            return false;
        }

        //goto left: keep left the same and update rights value to compare
        //goto right: keep right the same and update lefts value to compare
        return (valid(node.left, left, node.val) && valid(node.right,node.val, right));
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
