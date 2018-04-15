
import java.util.*;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
    
        List<List<Integer>> res = new ArrayList<>();
    
        if (root == null) {
        
            return res;
        }  
    
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    
        Queue<TreeNode> q = new LinkedList<>();
    
        Queue<Integer> cols = new LinkedList<>();

        q.add(root); 
    
        cols.add(0);

        int min = 0;
        int max = 0;
    
        while (!q.isEmpty()) {
            
	    TreeNode node = q.poll();
	    System.out.println("\n    node.val = " + node.val);
            
            int col = cols.poll();
	    System.out.println("    col = " + col);        

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
	    System.out.println("    map = " + map);

            if (node.left != null) {
                q.add(node.left); 
                cols.add(col - 1);
                min = Math.min(min, col - 1);
		System.out.println("        min = " + min);
            }
        
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
		System.out.println("        max = " + max);
            }
	    System.out.println("    q = " + q);
	    System.out.println("    cols = " + cols);
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

	System.out.println("res = " + res);
        return res;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9); root.right = new TreeNode(20);
        root.right.left = new TreeNode(15); root.right.right = new TreeNode(7);
	s1.verticalOrder(root);
    }    
}
