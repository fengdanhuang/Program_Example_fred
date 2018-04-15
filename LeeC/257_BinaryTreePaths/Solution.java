
import java.util.*;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> answer = new ArrayList<String>();
        
        if (root != null) searchBT(root, "", answer);
       
	System.out.println("answer = \n" + answer); 
        return answer;
    }
    
    private void searchBT(TreeNode root, String path, List<String> answer) {
	System.out.println("    searchBT(" + root.val + "," + path + "," + answer + ") ");       
 
        if (root.left == null && root.right == null) answer.add(path + root.val);
        
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
        
    }

    public static void main(String args[]){
        Solution s1 = new Solution();

	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2); root.right = new TreeNode(3);
	root.left.right = new TreeNode(5);
	s1.binaryTreePaths(root);

	root = new TreeNode(0);
	s1.binaryTreePaths(root);
    }
 
}
