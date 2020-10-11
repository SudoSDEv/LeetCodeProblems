class Solution {
    
    class Party implements Comparable<Party>{
        
        char data;
        List<Integer> list=new ArrayList<>();
        
        Party(char data, List<Integer> list){
            
            this.data=data;
            this.list=list;
            
        }
        
        @Override
        public int compareTo(Party p){
            
            for(int i=0;i<list.size();i++){
                if(list.get(i)>p.list.get(i)) return -1;
                else if(p.list.get(i)>list.get(i)) return 1;
            }
            
            return data-p.data;
            
        }
        
    }
    
    public String rankTeams(String[] votes) {
        
        List<Party> list=new ArrayList<>();
        TreeMap<Character, ArrayList<Integer>> map=new TreeMap<>();
        
        for(String vote : votes){
            
            for(int i=0;i<vote.length();i++){
                map.putIfAbsent(vote.charAt(i), Arrays.stream(new int[vote.length()]).boxed().collect(Collectors.toCollection(ArrayList::new)));
                                
                map.get(vote.charAt(i)).set(i,  map.get(vote.charAt(i)).get(i)+1);
                       
            
            }
        
        }

        TreeSet<Party> set=map.keySet().stream().map(x->new Party(x, map.get(x))).collect(Collectors.toCollection(TreeSet::new));//Used java8
        
        StringBuilder rs=new StringBuilder();
        for(Party p : set){
            rs.append(p.data+"");
            //list.add(new Party(key, map.get(key)));
        }
                                
        // Collections.sort(list);
        // for(Party p : list)
        // rs.append(p.data+"");
        
        return rs.toString();
        
    }
}
