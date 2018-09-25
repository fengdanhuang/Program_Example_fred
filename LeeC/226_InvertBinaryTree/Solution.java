


//Definition for a binary tree node.

class TreeNode {
    
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { val = x; }
}


class Solution {

    int countRec = 0;

    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;
        System.out.println("countRec = " + countRec);
        countRec++;        

        TreeNode right = invertTree(root.right);
        System.out.println("    invertTree(roo.right)");       
 
        TreeNode left = invertTree(root.left);
        System.out.println("    invertTree(roo.left)");       
        
        root.left = right;
        System.out.println("    root.left = right");
        
        root.right = left;
        System.out.println("    root.right = left");
        
        System.out.println("    " + root.val + "  ");
 
        return root;
        
    }

    public void printTree(TreeNode root){
        if(root != null){
            printTreeRecur(root);
        }else{
            return;
        }
        System.out.println("\n");    
    }    

    public void printTreeRecur(TreeNode root){
        
        System.out.print(root.val + "  ");
        if(root.left!=null) printTreeRecur(root.left);
        else System.out.print("null" + "  ");

        if(root.right!=null) printTreeRecur(root.right);
        else System.out.print("null" + "  ");
    }


    public static void main(String args[]){
     
        Solution sol = new Solution();

        TreeNode root=new TreeNode(4);
        TreeNode A=new TreeNode(2);TreeNode B=new TreeNode(7);
        TreeNode C=new TreeNode(1);TreeNode D=new TreeNode(3);TreeNode E=new TreeNode(6);TreeNode F=new TreeNode(9);
        root.left=A;root.right=B;
        A.left=C;A.right=D;B.left=E;B.right=F;
        C.left=null;C.right=null;
        D.left=null;D.right=null;
        E.left=null;E.right=null;
        F.left=null;F.right=null;  
 
        //sol.printTree(root);
        sol.invertTree(root); 
        //sol.printTree(root);
    }

}
