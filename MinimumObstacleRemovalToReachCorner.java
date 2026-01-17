class Solution {
    public int minimumObstacles(int[][] grid) {
        // apparently this is a 0-1 BFS algo,

        // instead of queue we use a deque, adding to the left(first) when no obstacles, and right (last) if theres an obstacle
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        // our dequw
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0}); // {0,0,0} represents {obstacles, r, c}
        visited[0][0] = true;
        while(!q.isEmpty()){
            //extract obs r c from q[0]
            int curr[] = q.pollFirst();
            int obs = curr[0], r = curr[1] , c = curr[2];

            // destination check?
            if(r == ROWS -1 && c == COLS -1 ){
                return obs;
            }

            // calc neighbours?
            int[][] neighbours = new int[][]{
                {r+1,c},
                {r-1,c},
                {r,c+1},
                {r,c-1},
            };

            // for all the dirs
            for(int[] nei : neighbours){
                int nr = nei[0], nc = nei[1];

                // "dont-do-bfs" cases : out of bounds and already visted
                if(
                    nr < 0 || nr >= ROWS || nc <0 || nc >= COLS ||
                    visited[nr][nc] == true
                ){
                    // simply continue
                    continue;
                }

                // mark as visited
                visited[nr][nc] = true;

                // if current cell has obs then add {obs+1, nr,nc} to last of queue
                // else add {obs, nr,nc} to first of queue
                if(grid[nr][nc] == 1){
                    q.offerLast(new int[]{obs+1, nr, nc});
                }else{
                    q.offerFirst(new int[]{obs, nr, nc});   
                }
            }

        }

        return -1; // unreachable
    }
}
