

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value = value;
    }
}


class GetValue{

    int getValue(TreeNode root, int i){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 0;
        if(index == i) return root.val;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                root = q.poll();
                index++;
                if(index == i) return root.val;
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
        }
        return -1;
    }
    public static void main(String args[]){
        GetValue gv = new GetValue();
    }
}
