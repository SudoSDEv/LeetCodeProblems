class TopVotedCandidate {

    class Pair {
        
        int person, time;
        Pair(int x, int y){
            person=x;
            time=y;
        }
        
    }
    
    ArrayList<Pair> list=new ArrayList<>();
    
    public TopVotedCandidate(int[] persons, int[] times) {
        
        int max=-1, maxPerson=-1;
        int[] count=new int[persons.length];
        
        for(int i=0;i<persons.length;i++){
            
            count[persons[i]]++;
            if(max<=count[persons[i]]){
                max=count[persons[i]];
                maxPerson=persons[i];
            }
            
            list.add(new Pair(maxPerson, times[i]));
            
        }
        
        
    }
    
    public int q(int t) {
        
        int i=0, j=list.size()-1;
        while(i<=j){
            
            int mid=i+(j-i)/2;
            Pair p=list.get(mid);
            if(p.time==t) return p.person;
            else if(t<p.time) j=mid-1;
            else i=mid+1;
            
        }
        
        return list.get(j).person;
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
