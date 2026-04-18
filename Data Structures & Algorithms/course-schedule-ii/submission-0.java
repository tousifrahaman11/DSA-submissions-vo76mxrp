class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> li = new ArrayList<>();
        Queue<Integer> q1 = new LinkedList<>();
        int[] id = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            li.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for(int i = 0; i<n; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            li.get(b).add(a);
            id[a]++;
        }
        for(int i = 0; i<numCourses; i++){
            if(id[i]==0) q1.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        int count = 0;
        while(!q1.isEmpty()){
            int co = q1.poll();  //course
            ans[idx++] = co;
            count++;
            for(int nm : li.get(co)){
                id[nm]--;
                if(id[nm] == 0){
                    q1.offer(nm);
                }
            }
            
        }
        if(count == numCourses) return ans;
        return new int[0];
     
    }
}
