class Solution {
    public String makeLargestSpecial(String s) {
        
        if(s.length()==0) return "";
        else{
            
            int i=0, count=0;
            List<String> list=new ArrayList<>();
            for(int j=0;j<s.length();j++){
                
                count+=s.charAt(j)=='1'?1:-1;
                if(count==0){
                    list.add(1+makeLargestSpecial(s.substring(i+1,j))+0);
                    i=j+1;
                }
                             
            }
                             
            Collections.sort(list,Collections.reverseOrder());
            return String.join("", list);                 
            
        }
        
    }
}
