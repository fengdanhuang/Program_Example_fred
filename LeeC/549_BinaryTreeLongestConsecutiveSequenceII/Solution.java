


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class Solution {
    
    int maxval = 0;
    
    public int longestConsecutive(TreeNode root) {
        longestPath(root);

	System.out.println("maxval = " + maxval);
        return maxval;
    }
    
    public int[] longestPath(TreeNode root) {

        if (root == null)
            return new int[] {0,0};
        
	int inr = 1, dcr = 1;
        
	if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        
	if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        
	maxval = Math.max(maxval, dcr + inr - 1);
        
	return new int[] {inr, dcr};
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	TreeNode root = new TreeNode(2);
	root.left = new TreeNode(1); root.right = new TreeNode(3);
	s1.longestConsecutive(root);

    }
    
}
