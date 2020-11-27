class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Stack<Integer> stack=new Stack<>();
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] p : prerequisites){
            
            int u=p[0], v=p[1];
            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(u);
            
        }

        LinkedList<Integer> list=new LinkedList<>();
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            if(visited[i]==0)
                if(!topoSort(map, visited, i, new int[numCourses], list))
                    return new int[0];
        
        return list.stream().mapToInt(x->x).toArray();
        
    }
    
    public boolean topoSort(Map<Integer, List<Integer>> map, int[] visited, int u, int[] cVisited, LinkedList<Integer> list){
        
        if(cVisited[u]==1) return false;
        if(visited[u]==1) return true;
        visited[u]=cVisited[u]=1;
        
        if(map.containsKey(u)){
            
            for(int v : map.get(u))
                    if(!topoSort(map, visited, v, cVisited, list))
                        return false;
            
        }
        
        cVisited[u]=0;
        list.addFirst(u);
        return true;
        
    }
    
}
