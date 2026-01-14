// Leetcode 200
// yt : https://youtu.be/CmHER8LHcDw
class Solution {
    public static void dfs(char[][] grid, int i, int j){
        // if water then simply return (out of borders is also water)
        if(i < 0 || i >= grid.length
            || j < 0 || j >= grid[0].length
            || grid[i][j] == '0'
        ){
            return; // dont do dfs 
        }

        // mark this as island as visited by simply making it water
        grid[i][j] = '0';

        //check on all 4 sides
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);
    }
    public int numIslands(char[][] grid) {
        // i will be using dfs

        // for every land that i see i will traverse through every horizontal and vertical land connected to it and mark it as vistited 
        // so that i dont perform dfs on "marked lands" and "water"
        int count =0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
