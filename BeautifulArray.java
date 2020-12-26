class Solution {
    public int[] beautifulArray(int N) {
        
        Map<Integer, int[]> map=new HashMap<>();    
        map.put(1, new int[]{1});
        return findOut(N, map);
        
    }
    
    public int[] findOut(int n, Map<Integer, int[]> map){
        
        if(map.containsKey(n)) return map.get(n);
        else{
            
            int[] res=new int[n];
            int c=0;
            for(int x :  findOut(n/2, map))
                res[c++]=2*x;
            for(int x : findOut((n+1)/2, map))
                res[c++]=2*x-1;
            map.put(n, res);
            return res;
            
        }    
        
    }
    
}
