class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        long currSum=0, maxSum=Integer.MIN_VALUE;
        int c=0, mod=1000000007;
        long sum=Arrays.stream(arr).reduce(0, (acc,item)->acc+item);
        
        for(int i=0;i<((k>1)?arr.length*2:arr.length);i++){
            
            currSum=Math.max(currSum+arr[c], arr[c])%mod;
            maxSum=Math.max(maxSum, currSum)%mod;
            c++;
            c%=arr.length;
            
        }
        
        if(sum<0 || k==1) return (int)(maxSum>0?maxSum%mod:0);
        else
            return (int)(maxSum+(sum*(k-2))%mod)%mod;
        
    }
}
