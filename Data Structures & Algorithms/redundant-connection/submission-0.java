class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] id = new int[n+1];
        List<List<Integer>> li = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            li.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            int u = edg[0], v = edg[1];
            li.get(u).add(v);
            li.get(v).add(u);
            id[u]++;
            id[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<=n; i++){
           if(id[i] == 1) q.offer(i); 
        }
        while(!q.isEmpty()){
            int node = q.poll();
            id[node]--;
            for(int nei : li.get(node)){
                id[nei]--;
                if(id[nei] == 1){
                    q.offer(nei);
                }
            }
        }
        for(int i = edges.length-1; i>= 0; i--){
            int u = edges[i][0];
            int v = edges[i][1];

            if(id[u] == 2 && id[v] > 0)  return new int[]{u,v};
        }
        return new int[0];
    }
}
