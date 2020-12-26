class Solution {
    public int[] avoidFlood(int[] rains) {
        
        Map<Integer, Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        int[] res=new int[rains.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        int prevDryIndex=-1;
        
        for(int i=0;i<rains.length;i++){
                            
            int day=rains[i];
            if(day!=0){
                
                res[i]=-1;
                if(map.getOrDefault(day, -1)>-1){
                    
                    Integer prev=set.higher(map.get(day));
                    if(prev==null) return new int[0];
                    else{
                        set.remove(prev);
                        res[prev]=day;
                        map.put(day, i);
                    }
                    
                }else
                    map.put(day, i);
                
            }else
                set.add(i);
            
        }
        
        for(int i=0;i<rains.length;i++)
            if(res[i]==Integer.MAX_VALUE)
                res[i]=1;
        
        return res;
        
    }
}
