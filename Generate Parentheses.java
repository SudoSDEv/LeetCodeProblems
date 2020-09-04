
class Solution {
    public List<String> generateParenthesis(int n) {
     
        List<String> list=new ArrayList<>();
        findOut(n-1,n,"(",list);
        return list;
        
    }
    
    public void findOut(int open, int close, String r, List<String> list){
        
        if(open==0){
            while(close-->0) r+=')';
            list.add(r);
        }else{
            
            if(open<close || close<open){
                findOut(open, close-1, r+")", list);
                findOut(open-1, close, r+"(", list);
            }else
                findOut(open-1, close, r+"(", list);
            
        }
        
    }
    
}
