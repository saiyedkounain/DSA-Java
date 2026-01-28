class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowB = 0;
        int rowE = matrix.length - 1;
        int colB = 0;
        int colE = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while(rowB <= rowE && colB <= colE){
            // traverse right
            for(int i=colB; i<=colE; i++){
                ans.add(matrix[rowB][i]);
            }
            rowB++;

            // traverse down
            for(int i=rowB; i <= rowE; i++){
                ans.add(matrix[i][colE]);
            }
            colE--;

            // traverse left
            // sanity check
            if(rowB <= rowE){
                for(int i=colE; i>= colB; i--){
                    ans.add(matrix[rowE][i]);
                }
            }
            rowE--;

            // traverse up
            // sanity check
            if(colB <= colE){
                for(int i=rowE; i>= rowB; i--){
                    ans.add(matrix[i][colB]);
                }
            }
            colB++;
        }

        return ans;
    }
}
