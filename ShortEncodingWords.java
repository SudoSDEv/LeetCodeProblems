class Solution {
    
 
    class Node{
        
        char data='$';
        int index=-1;
        HashMap<Character, Node> map=new HashMap<>();
        
        void insert(String word, int endIndex){
            
            Node cNode=this;
            for(int i=word.length()-1;i>=0;i--){
                cNode.map.putIfAbsent(word.charAt(i), new Node());
                cNode=cNode.map.get(word.charAt(i));
            }
            
            cNode.index=endIndex;
        }
        
    }
    
    public int minimumLengthEncoding(String[] words) {
     
        Node root=new Node();
        for(int i=0;i<words.length;i++)
            root.insert(words[i], i);
        
        int ans=0;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            
            Node u=stack.pop();
            if(u.index!=-1 && u.map.size()==0)
                ans+=words[u.index].length()+1;
            for(Node n:u.map.values())
                stack.push(n);
            
        }
        
        return ans;
        
    }
}
