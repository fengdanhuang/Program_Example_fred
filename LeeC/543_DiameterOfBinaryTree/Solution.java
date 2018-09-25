



//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
	System.out.println("max = " + max + "\n");
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        
        if (root == null) return 0;
       
	System.out.println("\n    maxDepth(" + "root=" + root.val + ")");
        
	int left = maxDepth(root.left);
	System.out.println("    left = " + left);
        
	int right = maxDepth(root.right);
        System.out.println("    right = " + right);

        max = Math.max(max, left + right);
        System.out.println("    max = " + max);

        return Math.max(left, right) + 1;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2); root.right = new TreeNode(3);
	root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
	s1.diameterOfBinaryTree(root);

    }
}
