class Solution {
    public int longestValidParentheses(String s) {
        
        int[] dp=new int[s.length()];
        int max=0;
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i)==')' && s.charAt(i-1)=='(')
                dp[i]=2+(i-2>=0?dp[i-2]:0);
            else if(s.charAt(i)==')' && s.charAt(i-1)==')'){
                
                int valid=dp[i-1], index=i-valid-1;
                if(index>=0 && s.charAt(index)=='('){
                    dp[i]=2+dp[i-1];
                    dp[i]+=index-1>=0?dp[index-1]:0;
                }
                
            }
                
            max=Math.max(max, dp[i]);                
            
        }
        
        return max;
        
    }
}
