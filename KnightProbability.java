class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        
        double[][][] dp=new double[N][N][K+1];
        
        double insideCount=findOut(dp, N, r, c, K);
        System.out.println(insideCount);
        return insideCount/Math.pow(8,K);
        
    }
    
    public int[] mx={-2,-2,-1,1,2,2,1,-1}, my={-1,1,2,2,1,-1,-2,-2};
    
    public boolean isValid(int i, int j, int n){
        
        return i>=0 && i<n && j>=0 && j<n;
        
    }
    
    public double findOut(double[][][] dp, int n, int i, int j, int k){
        
        if(k==0) return 1;
        else if(dp[i][j][k]!=0) return dp[i][j][k];
        else{
            
            double count=0;
            
            for(int c=0;c<8;c++){
                
                int cx=i+mx[c], cy=j+my[c];
                if(isValid(cx, cy, n))
                    count+=findOut(dp, n, cx, cy, k-1);
                
            }
            
            return dp[i][j][k]=count;
            
        }
        
    }
    
}
