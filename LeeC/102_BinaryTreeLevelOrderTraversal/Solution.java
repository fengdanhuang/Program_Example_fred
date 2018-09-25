
import java.util.*;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderRecur(res, root, 0);
        return res;
    }
    
    public void levelOrderRecur(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelOrderRecur(res, root.left, height+1);
        levelOrderRecur(res, root.right, height+1);
    }


    public static void main(String args[]){
	TreeNode tn1 = new TreeNode(3);
	TreeNode tn2 = new TreeNode(9);
	TreeNode tn3 = new TreeNode(20);
	TreeNode tn4 = new TreeNode(15);
	TreeNode tn5 = new TreeNode(7);
	
	tn1.left = tn2;
	tn1.right = tn3;

	tn2.left = null;
	tn2.right = null;

	tn3.left = tn4;
	tn3.right = tn5;
		
	tn4.left = null;
	tn4.right = null;
	
	tn5.left = null;
	tn5.right = null;
	
	Solution s1 = new Solution();
	List<List<Integer>> res = s1.levelOrder(tn1);
	System.out.println(res);

    }

}
