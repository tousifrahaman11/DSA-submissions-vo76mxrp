class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                     q.add(new int[] {i, j});
                }
            }
        }
        if(q.size() == 0) return;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r1 = node[0];
            int c1 = node[1];
            for(int[] dir : dirs){
                int r = r1+dir[0];
                int c = c1+dir[1];
                
                if(r >= n || c >= m || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[] { r, c});
                grid[r][c] = grid[r1][c1]+1;
            }
        }
    }
}
