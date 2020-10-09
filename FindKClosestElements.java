class Solution {
    
    class Pair implements Comparable<Pair>{
        
        int data, diff;
        
        Pair(int x, int y){ data=x; diff=y; }
        
        public int compareTo(Pair p){
            
            return diff-p.diff==0?data-p.data:diff-p.diff; 
            
        }
        
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> q=new PriorityQueue<>();
        for(int i : arr)
            q.add(new Pair(i, Math.abs(x-i)));
        
        List<Integer> list=new ArrayList<>();
        
        while(k-->0){
            
            Pair p=q.remove();
            System.out.println(p.data+" "+p.diff);
            list.add(p.data);
            
        }
        
        Collections.sort(list);
        
        return list;
        
    }
    
}
