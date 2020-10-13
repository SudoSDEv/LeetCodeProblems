class Solution {
    public String simplifyPath(String path) {
        
        String ans="";
        Stack<String> stack=new Stack<>();
        
        String[] a=path.split("/");
        for(String x : a){
                        
            if(x.equals("..")){ 
                if(!stack.isEmpty()) stack.pop();
            }else if(x.equals(".") || x.equals("")) continue;
            else{
                stack.push(x);
            }
                        
        }
        
        StringBuffer rs=new StringBuffer();
        rs.append("/");
        for(String x : stack)
            rs.append(x+"/");
        
        return rs.length()!=1?rs.toString().substring(0, rs.length()-1):rs.toString();
        
    }
}
