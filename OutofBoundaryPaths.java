class Solution {
    
    public int findPaths(int n, int m, int N, int i, int j) {
       
        int[][][] dp=new int[n][m][N+1];
        for(int[][] a : dp)
            for(int[] a1 : a)
                Arrays.fill(a1, -1);
        
        return findOut(dp, m, n, i, j, N);
        
    }
    
    public int[] mx={-1,0,1,0}, my={0,1,0,-1};
    public final int mod=1000000007;
    
    public boolean isValid(int i, int j, int n, int m){
        
        return i>=0 && i<n && j>=0 && j<m;
        
    }
    
    public int findOut(int[][][] dp, int m, int n, int i, int j, int total){
        
        if(total<=0) return 0;
        else if(dp[i][j][total]!=-1)
            return dp[i][j][total]; 
        else{
            
            int count=0;
            for(int c=0;c<4;c++){
                
                int cx=i+mx[c], cy=j+my[c];
                if(!isValid(cx,cy,n,m))
                    count++;
                else
                    count+=findOut(dp, m , n, cx, cy, total-1);
                count%=mod;
                
            }
            dp[i][j][total]=count;
            return count;
            
        }
        
    }
    
}
