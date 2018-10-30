



//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class Solution {
    
    public int maxDepth(TreeNode root) {
        
        if (root == null ) return 0;
      
        System.out.println("root = " + root.val);
 
        int left = maxDepth(root.left);
        System.out.println("left = " + left);

        int right = maxDepth(root.right);
        System.out.println("right = " + right);

        System.out.println("Math.max(left,right) + 1 = " + (Math.max(left,right)+1) );
        return Math.max(left, right) + 1;
        
    }

    public static void main(String args[]){
       
        Solution sol = new Solution();
 
        TreeNode root = new TreeNode(3);
        TreeNode A = new TreeNode(9);
        TreeNode B = new TreeNode(20);
        root.left = A; root.right = B;
        TreeNode C = new TreeNode(15);
        TreeNode D = new TreeNode(7);
        B.left = C; B.right = D;

        sol.maxDepth(root);
    }
}
