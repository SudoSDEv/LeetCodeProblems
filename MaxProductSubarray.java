class Solution {
    public int maxProduct(int[] nums) {
        
        int cMax=1, cMin=1, max=nums[0];
        for(int x : nums){
            
            int temp=cMax;
            cMax=Math.max(cMax*x, Math.max(x, cMin*x));
            cMin=Math.min(cMin*x, Math.min(x, temp*x));
            max=Math.max(max, cMax);

            //System.out.println(cMax+" "+cMin);
        }
        
        return max;
        
    }
}
