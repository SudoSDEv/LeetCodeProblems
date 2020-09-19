class Solution {
    public boolean isPossible(int[] nums) {
     
        HashMap<Integer, Integer> map=new HashMap<>(), extMap=new HashMap<>();
        for(int x:nums){
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x)+1);
        }
            
        for(int x:nums){
            
            if(map.get(x)==0) continue;
            else if(extMap.containsKey(x) && extMap.get(x)>0){
                extMap.put(x, extMap.get(x)-1);
                extMap.putIfAbsent(x+1, 0);
                extMap.put(x+1, extMap.get(x+1)+1);
            }else if(map.containsKey(x+1) && map.get(x+1)>0 && map.containsKey(x+2) && map.get(x+2)>0){
                
                map.put(x+1, map.get(x+1)-1);
                map.put(x+2, map.get(x+2)-1);
                extMap.putIfAbsent(x+3, 0);
                extMap.put(x+3, extMap.get(x+3)+1);
                
            }else
                return false;
            
            map.put(x, map.get(x)-1);
            
        }
        
        return true;
        
    }
}
