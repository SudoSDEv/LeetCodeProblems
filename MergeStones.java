class Solution {
    public int mergeStones(int[] stones, int K) {
     
        int[][] dp=new int[stones.length][stones.length];
        return findOut(dp, stones, K);
        
    }
    
    public int findOut(int[][] dp, int[] stones, int k){
        
        int n=stones.length;
        if((n-1)%(k-1)!=0) return -1;
        int[] sum=new int[n+1];
        for(int i=1;i<=n;i++)
            sum[i]=stones[i-1]+sum[i-1];
    
        for(int l=k;l<=n;l++){
            
            for(int i=0,j=l-1;j<n;i++,j++){
                
                dp[i][j]=Integer.MAX_VALUE;
                for(int split=i; split<j; split+=k-1)
                    dp[i][j]=Math.min(dp[i][j], dp[i][split]+dp[split+1][j]);
                    
                if((l-1)%(k-1)==0)
                    dp[i][j]+=sum[j+1]-sum[i];
                
            }
            
        }
        
        return dp[0][n-1];
        
    }
    
}
