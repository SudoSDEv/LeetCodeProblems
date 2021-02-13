class Solution {
    
    public List<Integer> findAnagrams(String s, String p){
        
        Map<Character, Integer> map=new HashMap<>();
        int c=0;
        for(char x: p.toCharArray())
            map.put(x, map.getOrDefault(x,0)+1);
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0,j=0;j<s.length();j++){
            
            char x = s.charAt(j);
            if(map.getOrDefault(x, -1)>0)
                c++;

            map.put(x, map.getOrDefault(x,0)-1);
            
            if(c==p.length())
                ans.add(i);
            
            if(j+1>=p.length()){
                
                x=s.charAt(i);
                if(map.get(x)>=0)
                    c--;

                map.put(x, map.get(x)+1);
                i++;
                
            }
            
        }
        
        return ans;
        
    }
    
}
