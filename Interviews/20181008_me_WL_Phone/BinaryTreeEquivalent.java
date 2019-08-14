
/*
Interviewer: PR (Indian Man)
Interview Result: UP

Question:

      5                           5
   6    (7)          ->        6     7
       8   9                       9   8

         5 
  ->   7   6
     9   8 


Check whether two binary tree are equivalent?

*/

class Node{

    int val;
    Node left;
    Node right;
    public Node(int value){
        this.val = value;
    }
}

public class BinaryTreeEquivalent{

    public boolean isEquivalent(Node a, Node b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        boolean re = isE(a, b);
        return re;
    }
    
    public boolean isE(Node a, Node b){
        if (isE(a.left, b.left)) {
            if (isE(a.right, b.right)) return true;
            else return false;
        }else if (isE(a.left, b.right)) {
            if (isE(a.right, b.left)) return true;
            else return false;
        }
        /*
        }else{
            return false;
        }*/
        
        if (a.val == b.val) return true;
        else return false;
    }

    public static void main(String[] args){
        Node a = new Node(5);
        Node b = new Node(5);

        BinaryTreeEquivalent bt = new BinaryTreeEquivalent();
        System.out.println("a, b isE(): " + bt.isEquivalent(a, b));
    }
}
     
