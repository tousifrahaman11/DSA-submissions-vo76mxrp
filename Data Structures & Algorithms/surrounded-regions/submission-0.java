class Solution {
    public void solve(char[][] board) {
        if(board == null || board[0] == null){
            return ;
        }
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i<r; i++){
            dfs(board, i, 0);
            dfs(board, i, c-1);
        }
        for(int j = 0; j<c; j++){
            dfs(board, 0, j);
            dfs(board, r-1, j);
        }
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }
        static void dfs(char[][] board, int p, int d){
            int ro = board.length;
            int co = board[0].length;

            if(p < 0 || p >= ro || d < 0 || d >= co || board[p][d] != 'O'){
                return;
            }

            board[p][d] = 'S';

            dfs(board, p+1, d);
            dfs(board, p-1, d);
            dfs(board, p, d+1);
            dfs(board, p, d-1);
        }
}
