class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
     
        int[][][][] dp=new int[s.length()][27][s.length()][k+1];
        Arrays.stream(dp).forEach(a1->Arrays.stream(a1).
                                 forEach(a2->Arrays.stream(a2).
                                        forEach(a3->Arrays.fill(a3, -1))));
        
        return findOut(s, s.length()-1, (char)('z'+1), 0, k, dp);
        
    }
    
    public int findOut(String s, int n, char prev, int cLength, int k, int[][][][] dp){
        
        if(n<0 || n+1==k) return 0;
        else if(dp[n][prev-'a'][cLength][k]!=-1) return dp[n][prev-'a'][cLength][k];
        else{
            
            int delete=Integer.MAX_VALUE, keep=Integer.MAX_VALUE;
            
            if(k>0)
                delete=findOut(s, n-1, prev, cLength, k-1, dp);
            
            if(s.charAt(n)==prev){
                
                keep=findOut(s, n-1, prev, cLength+1, k, dp);
                if(cLength==1 || (cLength+1+"").length()>(cLength+"").length())
                    keep++;
                
            }else
                keep=1+findOut(s, n-1, s.charAt(n), 1, k, dp);
            
            return dp[n][prev-'a'][cLength][k]=Math.min(delete, keep);
            
        }
        
    }
    
}
