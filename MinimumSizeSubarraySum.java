class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int cSum=0, min=Integer.MAX_VALUE, i=0;
        for(int j=0;j<nums.length;j++){
            
            cSum+=nums[j];
            if(cSum>=s){
                min=Math.min(min, j-i+1);
            }
            
            int slideI=i;
            while(slideI<j){
                
                if(cSum-nums[slideI]<s) break;
                else
                    cSum-=nums[slideI++];
                
            }
            
            if(slideI!=i){
                i=slideI;
                min=Math.min(min, j-i+1);
            }
            

        }
        
        if(cSum>=s)
            min=Math.min(min, nums.length-i);
            
        return min!=Integer.MAX_VALUE?min:0;    
        
    }
}
