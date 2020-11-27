class Solution {
    
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        int start=0, count=0;
        for(int[] course : courses){
            
            if(start+course[0]<=course[1]){
                courses[count++]=course;
                start+=course[0];
            }else{
                
                int max=0, pos=-1;
                for(int i=0;i<count;i++){
                    
                    if(max<courses[i][0]){
                        max=courses[i][0];
                        pos=i;
                    }
                    
                }
                                
                if(max>course[0]){
                    start-=(max-course[0]);
                    courses[pos]=course;
                }
                                
            }
            
        }
        
        return count;
        
    }
    
}
