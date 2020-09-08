class Solution {
    public int maxProfit(int[] prices) {
        
        int[] minDp=new int[prices.length], maxDp=new int[prices.length];
        int min=prices[0], max=prices[prices.length-1], ans=0;
        minDp[0]=0; 
        maxDp[prices.length-1]=0; 
        for(int i=1; i<prices.length; i++){
            
            min=Math.min(min, prices[i]);
            minDp[i]=Math.max(minDp[i-1], prices[i]-min);
            
        }
        
        for(int i=prices.length-2; i>=0; i--){
            
            max=Math.max(max, prices[i]);
            maxDp[i]=Math.max(maxDp[i+1], max-prices[i]);
            
        }
        
        max=0;
        for(int i=0;i<prices.length;i++){
            
            max=Math.max(max, minDp[i]+maxDp[i]);
            
        }
        
        return max;
        
    }
}
