class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fr = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fr++;
                }
            }
        }
        if(fr == 0) return 0;
        int min = 0;
          int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while(!q.isEmpty()){
            int size = q.size();
            boolean rt = false;

            for(int i = 0; i<size; i++){
                int[] cell = q.poll();
                for(int[] dir : directions){
                    int nx = cell[0] + dir[0];
                    int ny = cell[1] + dir[1];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        q.add(new int[] {nx, ny});
                        fr--;
                        rt = true;
                    }
                }
            }
            if(rt) min++;
        }
        return fr == 0 ? min : -1;
    }
}
