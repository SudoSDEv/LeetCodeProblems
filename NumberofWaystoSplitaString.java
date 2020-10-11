class Solution {
    
    public final long mod=1000000007;
    
    public int numWays(String s) {
        
        return findOut(s);
        
    }
    
    public int findOut(String s){
        
        long ans=0, sum=0;
        
        for(int i=0; i<s.length(); i++)
            sum+=((s.charAt(i)-'0')&1);
        
        long n=s.length()-1;
      
        if(sum==0) return (int)(((n*(n-1))/2)%mod);
        else if(sum%3!=0) return 0;
        else{
            
            long cWays1=0, cWays2=0, cSum=0;
            for(int i=0;i<s.length();i++){
                
                cSum+=((s.charAt(i)-'0')&1);
                if(cSum==sum/3) cWays1++;
                else if(cSum==2*sum/3) cWays2++;
                
            }
            
            return (int)((cWays1*cWays2)%mod);
            
        }
        
    }
    
}
