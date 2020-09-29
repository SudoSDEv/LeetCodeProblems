/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public long mod=1000000007;
    
    public int maxProduct(TreeNode root) {
        
        HashMap<TreeNode, Long> map=new HashMap<>();
        long rootSum=findSum(map, root);// caculate subtree sum for each TreeNode..
        return (int)(maxProduct(root, map, rootSum)%mod);
        
    }
    
    public long findSum(HashMap<TreeNode, Long> map, TreeNode root){
        
        if(root==null) return 0;
        else{
            
            map.put(root, (root.val+findSum(map, root.left)+findSum(map, root.right))); 
            return map.get(root);
            
        }
    }
    
    public long maxProduct(TreeNode root,HashMap<TreeNode, Long> map, long rootSum){
        
        if(root==null) return 0;
        else{
            
            long leftBreak=0, rightBreak=0;
            if(root.left!=null)
                leftBreak=map.get(root.left);
            if(root.right!=null)
                rightBreak=map.get(root.right);
            
            return Math.max(((rootSum-leftBreak)*leftBreak), 
                            Math.max(((rootSum-rightBreak)*rightBreak),            Math.max(maxProduct(root.left, map, rootSum),                                                                                     maxProduct(root.right, map, rootSum))));
                        
        }
        
    }
    
    
}
