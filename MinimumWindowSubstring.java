class Solution {
    public String minWindow(String s, String t) {
    
        HashMap<Character, Integer> map1=new HashMap<>(), map2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map1.putIfAbsent(t.charAt(i),0);
            map1.put(t.charAt(i), map1.get(t.charAt(i))+1);
        }
        
        int i=0, j=0, min=Integer.MAX_VALUE, count=0;
        String ans="";
        
        while(j<s.length()){
            
            if(map1.containsKey(s.charAt(j))){
                
                map2.putIfAbsent(s.charAt(j),0);
                map2.put(s.charAt(j), map2.get(s.charAt(j))+1);
                if(map2.get(s.charAt(j)).intValue()==map1.get(s.charAt(j)).intValue())
                    count++;
                
            }
            
            if(count==map1.size()){
                
                if(min>j-i+1){
                    min=j-i+1;
                    ans=s.substring(i,j+1);
                }
                
                int slideI=i;
                while(slideI<j){
                    
                    if(map2.containsKey(s.charAt(slideI)) &&                        map2.get(s.charAt(slideI)).intValue()-1<map1.get(s.charAt(slideI)).intValue()) break;
                    else if(map2.containsKey(s.charAt(slideI)))
                        map2.put(s.charAt(slideI), map2.get(s.charAt(slideI))-1);
                    slideI++;
                    
                }
                                
                
                if(slideI!=i){
                    i=slideI;
                    if(min>j-i+1){
                        min=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                    
                }
                
            }
            
            j++;
            
        }
                      
        return ans;
                    
    }
}
