class Solution {
    public int[] countBits(int num) {
    
        int[] count=new int[num+1];
        
        for(int i=0;i<17;i++){
            
            for(int x=0;x<=num;x++)
                if((x&(1<<i))>0) count[x]++;
            
        }
        
        return count;
        
    }
}
