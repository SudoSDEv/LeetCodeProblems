class Solution {
        
    public int superpalindromesInRange(String L, String R) {
     
        int ans=0;
        long r=Long.parseLong(R), l=Long.parseLong(L);
        
        for(int i=1;i<=100000;i++){
            
            StringBuilder ls=new StringBuilder(i+"");
            String rev=new StringBuilder(ls).reverse().toString();
            String inM=ls.toString()+rev;
            long join=Long.parseLong(inM);
            //System.out.println(join);
            join*=join;
            if(join>r) break;
            if(join>=l && isPal(join)) ans++;
            
        }
        
         for(int i=1;i<=100000;i++){
            
            StringBuilder ls=new StringBuilder(i+"");
            String rev=new StringBuilder(ls).reverse().toString();
            String exM=ls.toString()+rev.substring(1);
            long join1=Long.parseLong(exM);
            //System.out.println(join1);
            join1*=join1;
            if(join1>r) break;
            if(join1>=l && isPal(join1)) ans++;
            
        }
        
        return ans;
        
    }
    
    public boolean isPal(long x){
        
        String r=x+"";
        if(r.equals(new StringBuilder(r).reverse().toString()))
           return true;
        return false;   
        
    }
    
}
