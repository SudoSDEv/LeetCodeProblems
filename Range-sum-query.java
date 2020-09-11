class NumArray {

    class Node{
        
        int data=0, i=-1, j=-1;
        Node left, right=null;
        Node(int a, int b, int c, Node left, Node right){
            data=a;i=b;j=c;
            this.left=left;
            this.right=right;
        }
        
    }
    
    Node root=null;
    
    public Node formST(int[] a, int i, int j){
        
        if(i>j) return null;
        if(i==j) return new Node(a[i], i, j, null, null);
        else{
            int mid=(i+j)/2;
            Node left=formST(a, i, mid), right= formST(a, mid+1, j);
            return new Node(left.data+right.data, i, j, left, right);
        }
        
    }
    
    public Node updateST(Node root, int i, int val){
        
        if(i<root.i || i>root.j) return root;
        else if(root.i==root.j && root.i==i) root.data=val;
        else
            root.data=updateST(root.left, i, val).data+updateST(root.right, i, val).data;
        
        return root;
        
    }
    
    public int sumST(Node root, int i, int j){
        
        if(i>j) return 0;
        if(j<root.i || i>root.j) return 0;
        else if(root.i==root.j || root.i==i && root.j==j) return root.data;
        else            
            return sumST(root.left, i, j)+sumST(root.right, i, j);   
        
    }
    
    public NumArray(int[] nums) {
        
        this.root=formST(nums, 0, nums.length-1);
        
    }
    
    public void update(int i, int val) {
        
        updateST(root, i, val);
        
    }
    
    public int sumRange(int i, int j) {
        
        return sumST(root, i, j);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
