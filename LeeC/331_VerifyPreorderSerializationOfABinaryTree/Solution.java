


class Solution {
    
    public boolean isValidSerialization(String preorder) {
	System.out.println("\npreorder = " + preorder);   
 
        String[] nodes = preorder.split(",");
    
        int diff = 1;
    
        for (String node: nodes) {
	    System.out.println("    node = " + node);
	    System.out.println("    diff = " + diff + "\n");
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

        String s = new String("9,3,4,#,#,1,#,#,2,#,6,#,#");
	s1.isValidSerialization(s); 

	s = new String("1,#");
	s1.isValidSerialization(s); 
	
	s = new String("9,#,#,1");
	s1.isValidSerialization(s); 
	
    }    
}
