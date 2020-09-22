class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int max=0;
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for(int i=1;i<=grid.length;i++)
            for(int j=1;j<=grid[0].length;j++)
                if(grid[i-1][j-1]==1){
                    
                    int left=dp[i][j-1]%1000+1, right=dp[i-1][j]/1000+1;
                    dp[i][j]=left+right*1000;
                    for(int k=Math.min(dp[i][j]%1000, dp[i][j]/1000); k>max; k--){
                        
                        if(dp[i][j-k+1]/1000>=k && dp[i-k+1][j]%1000>=k){
                            max=Math.max(max, k);
                            break;
                        }
                        
                    }
                    
                }
        
        return max*max;
        
    }
}
