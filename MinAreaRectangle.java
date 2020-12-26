class Solution {
    
    class Pair{
        
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        
        @Override
        public boolean equals(Object o){
            
            Pair p=(Pair)o;
            return p.x==x && p.y==y;
            
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
        
    }
    
    public int minAreaRect(int[][] points){
        
        Set<Pair> set=new HashSet<>();
        for(int[] x : points)
            set.add(new Pair(x[0], x[1]));
        
        int area=Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++){
            
            int[] point=points[i];
            for(int j=i+1;j<points.length;j++){
                
                int[] point1=points[j];
                if((point[0]<point1[0] && point[1]<point1[1])|| (point[0]>point1[0] && point[1]>point1[1])){
                    int x1=point[0], y1=point1[1], x2=point1[0], y2=point[1];
                    int x11=point1[0], y11=point[1], x21=point[0], y21=point1[1];
                    if((point[0]<point1[0] && point[1]<point1[1]) && set.contains(new Pair(x1, y1)) && set.contains(new Pair(x2, y2)))
                        area=Math.min(area, (x2-point[0]) * (y1-point[1]));
                    else if((point[0]>point1[0] && point[1]>point1[1]) && set.contains(new Pair(x11, y11)) && set.contains(new Pair(x21, y21)))
                        area=Math.min(area, (x21-point1[0]) * (y11-point1[1]));

                }
            
            }
            
        }
        
        return area==Integer.MAX_VALUE?0:area;
        
    }
    
}
