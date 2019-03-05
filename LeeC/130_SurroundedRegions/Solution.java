


class Solution {
    
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0) return;
        
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                
                if (board[i][j] == '*') {
                    
                    board[i][j] = 'O';
                    
                }else if (board[i][j] == 'O') {
                    
                    board[i][j] = 'X';
                    
                }
            }
        }
        
    }
    
    
    public void dfs(char[][] board, int i, int j) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = '*';
        
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
        
    }

    public static void main(String args[]){
        


    }
}
