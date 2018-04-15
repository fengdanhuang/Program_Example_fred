
import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (!isLeaf(root)) {
            res.add(root.val);
        }

        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }

        addLeaves(res, root);
        
	Stack<Integer> s = new Stack<>();
        
	t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
	System.out.println("s = " + s);

        while (!s.empty()) {
            res.add(s.pop());
        }

	System.out.println("res = " + res);
        return res;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();
	
	TreeNode root = new TreeNode(1);
	root.right = new TreeNode(2); 
	root.right.left = new TreeNode(3); root.right.right = new TreeNode(4);
	s1.boundaryOfBinaryTree(root);
	

    }
}

