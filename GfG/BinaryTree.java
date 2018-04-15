

// Java program for different tree traversals
 
/* Class containing left and right child of current
   node and key value*/
class BiNode{

    int key;
    BiNode left;
    BiNode right;
 
    public BiNode(int item){
        key = item;
        left = right = null;
    }
}
 
class BinaryTree{
    // Root of Binary Tree
    BiNode root;
 
    BinaryTree(){
        root = null;
    }
 
    void postorder(BiNode node){//  "bottom-up" postorder traversal.
	System.out.println("postorder(" + node +")");
        
	if (node == null) return;
 
        postorder(node.left);
        postorder(node.right); 
        System.out.print(node.key + " ");
    }
 
    void inorder(BiNode node){
        if (node == null) return;
 
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }
 
    void preorder(BiNode node){
        if (node == null) return;
 
        System.out.print(node.key + " ");
        preorder(node.left); 
        preorder(node.right);
    }
 
 
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new BiNode(1);
        tree.root.left = new BiNode(2);
        tree.root.right = new BiNode(3);
        tree.root.left.left = new BiNode(4);
        tree.root.left.right = new BiNode(5);
 
        System.out.println("\nPreorder traversal of binary tree is\n ");
        tree.preorder(tree.root);
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.inorder(tree.root);
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postorder(tree.root);
    }
}
