class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // edge case
        // do bfs and just add the last node at each level to the list
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        while(!q.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();

            for(int i=0; i< size; i++){
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);

                // move left and right
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }

            // add the last node in this level to our ans
            int n = currLevel.size();
            int lastNode = currLevel.get(n-1);
            ans.add(lastNode);
        }

        return ans;
    }
}
