

/**
 * Definition for a binary tree node.
 */ 
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class Solution {
    
    public boolean isValidBST(TreeNode root) {
        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        
        if(root!=null) System.out.println("isValidBST("+root.val+","+minVal+","+maxVal+");");       
        
        if (root == null) return true;
        
        if (root.val >= maxVal || root.val <= minVal) return false;
        
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String args[]){
        Solution sol = new Solution();

        TreeNode root=new TreeNode(2);
        TreeNode A=new TreeNode(1);TreeNode B=new TreeNode(3);
        root.left=A;root.right=B;
        A.left=null;A.right=null;B.left=null;B.right=null;
        sol.isValidBST(root);
        System.out.println();

        root=new TreeNode(5);
        A=new TreeNode(1);B=new TreeNode(4);
        TreeNode C=new TreeNode(3);TreeNode D=new TreeNode(6);
        root.left=A;root.right=B;
        A.left=null;A.right=null;B.left=C;B.right=D;
        C.left=null;C.right=null;D.left=null;D.right=null;
        sol.isValidBST(root);
        System.out.println();

    }
}

