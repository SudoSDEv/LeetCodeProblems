class Solution {
    
    HashMap<Integer, Boolean> map=new HashMap<>();
    
    public boolean canIWin(int max, int total) {
       
       if(total<=0) return true;
       if((max*(max+1)/2)<total) return false;
       else
            return canIWin(max, total, 0); //0=visited state...    
        
    }
    
    public boolean canIWin(int max, int total, int visited){
        
        if(total<=0) return false;
        else if(map.containsKey(visited)) return map.get(visited);
        else{
            
            boolean ans=false;
            
            for(int i=max;i>=1;i--){
                
                if((1<<i & visited)==0)
                    if(!canIWin(max, total-i, visited|(1<<i))){
                        ans = true;
                        break;
                    }
                
            }
            
            map.put(visited, ans);
            return ans;
            
        }
        
    }
    
        
}
