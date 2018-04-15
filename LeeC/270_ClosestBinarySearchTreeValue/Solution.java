


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}




class Solution{

    public int closestValue(TreeNode root, double target) {
        System.out.println("closestValue(root.val=" + root.val + ",  target=" + target + ")");

        int a = root.val;

    	TreeNode kid = target < a ? root.left : root.right;
    	
	if (kid == null) return a;
    	
	int b = closestValue(kid, target);
    	
	if (Math.abs(a - target) < Math.abs(b - target)) 
	    return a;
	else
	    return b;
    }

    public static void main(String args[]){

	Solution s1 = new Solution();
	
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(4); root.right = new TreeNode(5);
	double d = 4.428571;
	s1.closestValue(root, d);

    }

}
