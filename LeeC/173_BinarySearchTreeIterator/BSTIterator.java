
import java.util.*;


// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    private void pushAll(TreeNode node) {
        
        for (; node != null; stack.push(node), node = node.left);
       
	System.out.println("stack = " + stack); 
    }
    

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return !stack.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        System.out.println("tmpNode.val = " + tmpNode.val);
	pushAll(tmpNode.right);
        return tmpNode.val;
    }
 
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);

        // Your BSTIterator will be called like this:
        BSTIterator i = new BSTIterator(root);
        //while (i.hasNext()) v[f()] = i.next();
        while (i.hasNext()) i.next();
    }	
	
}

