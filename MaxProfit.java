class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int cSell=0, cHold=-prices[0];
       for(int i=1;i<prices.length;i++){
           
           int temp=cSell;
           cSell=Math.max(cSell, cHold+prices[i]-fee);
           cHold=Math.max(cHold, temp-prices[i]);
           
       }
        
        return cSell;
        
    }
}
