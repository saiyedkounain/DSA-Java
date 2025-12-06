class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // lets create a prefix matrix
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] prefixM = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int top =0, left =0, topLeft = 0;

                if(i > 0){
                    top = prefixM[i-1][j];
                }
                if(j > 0){
                    left = prefixM[i][j-1];
                }
                if(i>0 && j>0){
                    topLeft = prefixM[i-1][j-1];
                }
                
                prefixM[i][j] = matrix[i][j] + top + left - topLeft;

            }
        }

        
        int ans = 0;

        // real deal
        for(int r1 =0; r1 < n; r1++){
            for(int r2 = r1; r2 < n; r2++){
                Map<Integer, Integer> map = new HashMap<>();
                // the first edge 
                map.put(0,1);
                for(int c = 0; c < m; c++){
                    int toDelete = 0;
                    if(r1 > 0){
                        toDelete = prefixM[r1-1][c];
                    }
                    int prefix = prefixM[r2][c] - toDelete;
                    int diff = prefix - target;
                    if(map.containsKey(diff)){
                        ans += map.get(diff);
                    }
                    //update the hashmap
                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);

                }
            }
        }



        return ans;
    }
}
