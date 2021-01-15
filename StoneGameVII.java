class Solution {
    
    int picked=0;
    
    public int stoneGameVII(int[] stones) {
        
        int[][] dp=new int[stones.length][stones.length];        
        return findOut(stones, 0, stones.length-1, dp);
        
    }
    
    public int findOut(int[] stones, int i, int j, int[][] dp){
        
        if(i==j || i>j) return 0;
        else if(i+1==j) return Math.max(stones[i], stones[j]);
        else if(dp[i][j]!=0) return dp[i][j];
        else{
            
            return dp[i][j]=Math.max(Math.min(stones[i+1]+findOut(stones, i+2, j, dp), stones[j]+findOut(stones, i+1, j-1, dp)),Math.min(stones[i]+findOut(stones, i+1, j-1, dp), stones[j-1]+findOut(stones, i, j-2, dp)));
            
        }
        
    }
    
}
