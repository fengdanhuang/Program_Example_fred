


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class Solution {
    
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);

	System.out.println("maxLength = " + maxLength);
        return maxLength;
    }

    private void dfs(TreeNode p, TreeNode parent, int length) {
	if (p!=null && parent!=null)
	    System.out.println("\n    dfs(" + p.val + ",  " + parent.val + ",  " + length + ")");
	

        if (p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        System.out.println("    length = " + length);
	
	maxLength = Math.max(maxLength, length);
	System.out.println("    maxLength = " + maxLength);	

        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	TreeNode[] t = new TreeNode[]{new TreeNode(1), new TreeNode(3), new TreeNode(2), new TreeNode(4), new TreeNode(5)};
	t[0].right = t[1];
	t[1].left = t[2]; t[1].right = t[3];
	t[3].right = t[4];
	s1.longestConsecutive(t[0]);

    }    
}
