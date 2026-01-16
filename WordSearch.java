class Solution {
    // lets make these vars global so that we dont have to pass it again and again
    int ROWS, COLS;
    String word;
    boolean[][] visited;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.board = board;
        this.word = word;
        visited = new boolean[ROWS][COLS];

        // run dfs on each cell

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(dfs(r,c,0)){ // if it ever returns true
                    return true;
                    // dfs(row, column, the indx of the char we are looking for in word);
                }
            }
        }
        // if it never found the word 
        return false;
    }

    public boolean dfs(int r, int c, int i){
        // true case: if we are at the end of the word
        if(i == word.length()){
            return true;
        }

        // false cases
        //1: out of bounds
        //2: not the char we are looking for
        //3: already visited
        
        if(
            r < 0 || r >= ROWS ||
            c < 0 || c >= COLS ||
            board[r][c] != word.charAt(i) ||
            visited[r][c] == true
        ){
            return false;
        }

        // normal op: marks as visted and visted all of its neighbours then backtrack by setting visited to false
        visited[r][c] = true;

        boolean res = (
            dfs(r+1,c,i+1) ||
            dfs(r-1,c,i+1) ||
            dfs(r,c+1,i+1) ||
            dfs(r,c-1,i+1) 
        );
        //backtrack
        visited[r][c] = false;

        return res;
    }
}
