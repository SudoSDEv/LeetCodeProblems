class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] dp=new int[n+1][n+1];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            
            min=Math.min(min, i+Math.max(findOut(1,i-1,dp), findOut(i+1,n,dp)));
            
        }
        
        return n!=1?min:0;
        
    }
    
    public int findOut(int i, int j, int[][] dp){
        
        if(i==j || i>j) return 0;
        else if(dp[i][j]!=0) return dp[i][j];
        else{
            
            int min=Integer.MAX_VALUE;
            
            for(int c=i;c<=j;c++){
            
                min=Math.min(min, c+Math.max(findOut(i,c-1,dp), findOut(c+1,j,dp)));
            
            }
            
            return dp[i][j]=min;
            
        }
        
    }
    
    
}
