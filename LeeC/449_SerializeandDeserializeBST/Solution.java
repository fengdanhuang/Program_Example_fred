


//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb =new StringBuilder();
        
        dfs(root, sb);
        
        return sb.toString();
        
    }
    
    public void dfs(TreeNode root, StringBuilder sb){
        
        if(root == null){
            sb.append("N");
            return;
        }
        
        sb.append(root.val);
        
        sb.append(",");
        
        dfs(root.left, sb);
        
        sb.append(",");
        
        dfs(root.right, sb);
        
        
    }
    
    private int iter = 0;
    
    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
        
        String[] split = data.split(",");
        
        return util(split);
        
    }
    
    public TreeNode util(String[] data) {
        
        if(iter > data.length -1) return null;
        
        if(data[iter].equals("N")) return null;
        
        
        TreeNode root = new TreeNode(Integer.valueOf(data[iter]));
        
        iter++;
        
        root.left = util(data);
        
        iter++;
        
        root.right = util(data);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
