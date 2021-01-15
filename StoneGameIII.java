class Solution {
    
    public String stoneGameIII(int[] stoneValue) {
        
        Map<Integer, Integer> map=new HashMap<>();
        int maxScore = findOut(stoneValue, 0, stoneValue.length-1, map);
        int sum=Arrays.stream(stoneValue).reduce(0, (acc, item)->acc+item);
        return sum-maxScore<maxScore?"Alice":(sum-maxScore==maxScore?"Tie":"Bob");
        
    }
    
    public int findOut(int[] a, int i, int j, Map<Integer, Integer> map){
        
        if(i>j) return 0;
        if(i==j) return a[i];
        if(i+1==j) return Math.max(a[i],a[i]+a[j]);
        if(map.containsKey(i)) return map.get(i);
        else{
            
            int first=a[i] + Math.min(findOut(a,i+2,j,map), Math.min(findOut(a,i+3,j,map),findOut(a,i+4,j,map))); 
            int second=a[i]+a[i+1]+Math.min(findOut(a,i+3,j,map),Math.min(findOut(a,i+4,j,map),findOut(a,i+5,j,map)));                                             int third=a[i]+a[i+1]+a[i+2]+Math.min(findOut(a,i+4,j,map), Math.min(findOut(a,i+5,j,map),findOut(a,i+6,j,map)));
            
            int max=Math.max(first, Math.max(second,third));
            map.put(i, max);
            return max;
            
        }
        
    }    
    
}
