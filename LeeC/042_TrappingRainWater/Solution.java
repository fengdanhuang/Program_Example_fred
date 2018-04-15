




class Solution {
    

    public int trap(int[] height) {

        int ans = 0;
        
	for (int i = 1; i < height.length - 1; i++) {
            
	    int max_left = 0, max_right = 0;
            
	    for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
		System.out.println("        max_left = " + max_left);
            }
            
	    for (int j = i; j < height.length; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
		System.out.println("        max_right = " + max_right);
            }
            ans += Math.min(max_left, max_right) - height[i];
	    System.out.println("    ans = " + ans);
        }
	
	System.out.println("ans = " + ans);
        return ans;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
	s1.trap(height);	

    }    
    
}
