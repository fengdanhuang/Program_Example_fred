


//Definition for binary tree with next pointer.
class TreeLinkNode {
    
    int val;
    TreeLinkNode left, right, next;
    
    TreeLinkNode(int x) { val = x; }
}


class Solution {
    
    public void connect(TreeLinkNode root) {
        
        if(root == null || root.left == null) return;
        
        connectNodes(root.left, root.right);
        
    }
    
    public void connectNodes(TreeLinkNode node1, TreeLinkNode node2) {
        
        node1.next = node2;
        
        if(node1.left != null) {
            
            connectNodes(node1.right, node2.left);
            
            connectNodes(node1.left, node1.right);
            
            connectNodes(node2.left, node2.right);
            
        }
        
    } 

    public static void main(String args[]){
        Solution sol = new Solution();

        

    }
}

