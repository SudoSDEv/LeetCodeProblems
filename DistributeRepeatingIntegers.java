class Solution {
        
    public boolean canDistribute(int[] nums, int[] quantity) {
     
        Map<Integer, Integer> map=new HashMap<>();
        for(int x:nums)   
            map.put(x, map.getOrDefault(x,0)+1);
        
        
        Arrays.sort(quantity);
        return findOut(quantity, map, quantity.length-1);
        
    }
    
    public boolean findOut(int[] a, Map<Integer, Integer> map, int n){
        
        if(n<0) return true;
        else{
            
            Set<Integer> set=new HashSet<>();
            for(int key : map.keySet()){
                
                if(map.get(key)>=a[n] && set.add(map.get(key))){
                    
                    map.put(key, map.get(key)-a[n]);
                    if(findOut(a, map, n-1))
                        return true;
                    
                    map.put(key, map.get(key)+a[n]);
                    
                }
                
            }
            
            //dp.put(new Pair(n,new HashMap<>(map)), false);
            return false;
            
        }
        
    }
    
}
