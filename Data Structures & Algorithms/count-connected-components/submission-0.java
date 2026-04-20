class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 0; i<n; i++){
            li.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            li.get(u).add(v);
            li.get(v).add(u);
        }
        
        
        boolean[] vis = new boolean[n];
        int comp = 0;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                bfs(i, li, vis);
                comp++;
            }
        }
        return comp;
    }
    void bfs(int start, List<List<Integer>> li, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : li.get(node)){
                if(!vis[nei]){
                vis[nei] = true;
                q.add(nei);
                }
            }
        }
    
    }
}
