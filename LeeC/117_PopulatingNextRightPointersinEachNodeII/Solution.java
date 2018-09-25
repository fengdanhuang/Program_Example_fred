



//Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    
    TreeLinkNode(int x) { val = x; }
}


class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                
                //move to next node
                cur = cur.next;
                
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }

    public static void main(String args[]){
        Solution sol = new Solution();

        TreeLinkNode root=new TreeLinkNode(1);
        TreeLinkNode A=new TreeLinkNode(2);TreeLinkNode B=new TreeLinkNode(3);
        TreeLinkNode C=new TreeLinkNode(4);TreeLinkNode D=new TreeLinkNode(5);TreeLinkNode E=new TreeLinkNode(7);
        root.left=A;root.right=B;
        A.left=C;A.right=D;B.left=null;B.right=E;
        C.left=null;C.right=null;D.left=null;D.right=null;E.left=null;E.right=null;

        sol.connect(root);
    }
    
}

