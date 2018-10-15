



class Solution {
    
    public int countUnivalSubtrees(TreeNode root) {
        
        if(root == null)return 0;
        
        return helper(root)[1];
    }
    
    public int[] helper(TreeNode root){
        
        int isUni = 0;
        int res = 0;
        
        if(root.left != null){
            
            int[] leftres = helper(root.left);
            
            if(root.val != root.left.val || leftres[0] == 1) isUni = 1;
            
            res += leftres[1];
        }
        
        if(root.right != null){
            
            int[] rightres = helper(root.right);
            
            if(root.val != root.right.val || rightres[0] == 1) isUni = 1;
            
            res += rightres[1];
        }
        
        int total = (isUni == 0?1+res:res);
        
        int[] ret = {isUni, total};
        
        return ret;
    }
    
}
