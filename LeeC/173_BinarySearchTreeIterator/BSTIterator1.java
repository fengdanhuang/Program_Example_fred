
import java.util.*;


/**
 * Definition for binary tree
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class BSTIterator1 {
    
    List<TreeNode> list =new ArrayList<TreeNode>();
    
    public BSTIterator1(TreeNode root) {
        
        while(root != null){
            list.add(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        System.out.println("list.size() = " + list.size());
        if(list.size()!=0){
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result=list.remove(list.size()-1);

        System.out.println("result = " + result);
        TreeNode curr=result;
        if(curr.right!=null){
            curr=curr.right;
            while(curr!=null){
                list.add(curr);
                curr=curr.left;
            }
        }
        return result!=null?result.val:-1;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);       
 
        //Your BSTIterator will be called like this:
        BSTIterator1 i = new BSTIterator1(root);
        while (i.hasNext()) i.next();
    }
}


