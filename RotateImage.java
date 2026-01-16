class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // this is apparently a 4 cell swap on all layers of the matrix

        for(int i=0; i < (n+1)/2; i++){
            for(int j=0; j < n/2 ; j++){
                // the confusing part
                int topR = i, topC = j;
                int rightR = j, rightC = n - 1 - i;
                int bottomR = n - 1 - i, bottomC = n - 1 - j;
                int leftR = n-1-j, leftC = i;

                // 
                int temp = matrix[leftR][leftC];

                // left has bottom
                matrix[leftR][leftC] =  matrix[bottomR][bottomC];
                // bottom has right;
                matrix[bottomR][bottomC] =  matrix[rightR][rightC];
                //right has top
                matrix[rightR][rightC] = matrix[topR][topC];
                // top has temp
                matrix[topR][topC] = temp;
            }
        }
    }
}
