class Solution {
    public void rotate(int[][] matrix) {
        // another easy solution (i did come up with this but couldnt write the code for it)
        // transpose the matrix and then reflect / reverse vertically
        int n = matrix.length;
        for(int i=0;i<n; i++){
            for(int j=i+1; j <n; j++){ //0,1 <-> 1,0  and so on
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse vertically
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
