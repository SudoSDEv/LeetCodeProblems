class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1000000;
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=1000000;
        
        for(int i=1;i<=grid.length;i++)
            for(int j=1;j<=grid[0].length;j++){

                dp[i][j]=grid[i-1][j-1];
                if(i==1 && j==1) continue;
                dp[i][j]+=Math.min(dp[i][j-1], dp[i-1][j]);
                
            }
        

        return dp[grid.length][grid[0].length];
        
    }
}
