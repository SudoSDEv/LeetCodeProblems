class NumArray {

    int[] pSum=null;
    
    public NumArray(int[] nums) {
        
        if(nums.length>0){
            pSum=new int[nums.length];
            pSum[0]=nums[0];
            for(int i=1;i<nums.length;i++)
                pSum[i]=nums[i]+pSum[i-1];
        }
        
    }
    
    public int sumRange(int i, int j) {
        
        if(pSum.length>0)
            return pSum[j]-(i-1>=0?pSum[i-1]:0);
        else
            return 0;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
