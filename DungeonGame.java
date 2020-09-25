class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
       return findOut(dungeon, 1, 1200);        
        
    }
    
    public int findOut(int[][] a, int i, int j){
        
        if(i<=j){
            
            int mid=i+(j-i)/2;
            boolean r=findOut(a, mid);
            if(r){
                int left=findOut(a,i,mid-1);
                return left<0?mid:left;
            }else
                return findOut(a, mid+1, j);
            
        }else
            return -1;
        
    }
 
    public boolean findOut(int[][] a, int initE){

        int[][] dp=new int[a.length][a[0].length];
        if(initE+a[0][0]<=0) return false;
        else dp[0][0]=initE+a[0][0];
        
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                
                if(i==0 && j==0){ continue; }
                int topRes=Integer.MIN_VALUE, leftRes=Integer.MIN_VALUE, top=0, left=0;
                if(i>0){
                    topRes=dp[i-1][j]+a[i][j];
                    top=dp[i-1][j];
                }if(j>0){
                    leftRes=dp[i][j-1]+a[i][j];
                    left=dp[i][j-1];
                }
                
                if(top<=0 && left<=0)
                    dp[i][j]=0;
                else
                    dp[i][j]=Math.max(leftRes, topRes);
                
            }
                                                      
        }
        
        return dp[a.length-1][a[0].length-1]>0?true:false;        
        
    }
    
}
