class Solution {
    
    int c=0;
    
    public boolean isValidSerialization(String preOrder) {
        
        boolean result = findOut(preOrder.split(","));
        if(c<preOrder.split(",").length) return false;
        else return result;
        
    }
    
    public boolean findOut(String[] preOrder){
        
        System.out.println(c+" ");
        if(c>=preOrder.length) return false;
        else if(preOrder[c].charAt(0)=='#'){ c++; return true; }
        else{
            
            c++;
            return findOut(preOrder) & findOut(preOrder);
            
        }
        
    }
    
}
