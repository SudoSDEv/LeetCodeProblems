class Solution {
    
    class Pair{
        
        int i, j;
        Pair(int x, int y){
            i=x;j=y;
        }
        
        @Override
        public boolean equals(Object o){
            
            Pair p=(Pair)o;
            return i==p.i && j==p.j;
            
        }
        
        @Override
        public int hashCode(){ return 1; }
        
    }

    HashMap<Pair, Integer> map=new HashMap<>();     
    
    public boolean PredictTheWinner(int[] nums) {
    
        int sum=0, max=findOut(nums, 0, nums.length-1);
        for(int x:nums) sum+=x;
        return sum-max<=max?true:false;
        
    }
    
    public int findOut(int[] a, int i, int j){
        
        if(i==j) return a[i];
        else if(i+1==j) return Math.max(a[i], a[j]);
        else if(map.containsKey(new Pair(i,j))) return map.get(new Pair(i,j));
        else{
            
            int max = Math.max(a[i]+Math.min(findOut(a,i+1,j-1), findOut(a, i+2, j)), a[j]+Math.min(findOut(a, i+1, j-1), findOut(a, i, j-2)));
            map.put(new Pair(i, j), max);
            return max;
            
        }
        
    }    
    
}
