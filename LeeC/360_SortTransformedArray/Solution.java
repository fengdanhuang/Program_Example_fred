


public class Solution {
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();

        int n = nums.length;
        
	int[] sorted = new int[n];
        
	int i = 0, j = n - 1;
        
	int index = a >= 0 ? n - 1 : 0;
        
	while (i <= j) {
            if (a >= 0) {
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
	
	for(int s = 0; s<sorted.length; s++)
	    System.out.print(sorted[s] + "  ");
	System.out.println();	
        return sorted;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    
    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int[]{-4, -2, 2, 4};
	int a = 1, b = 3, c = 5;
	s1.sortTransformedArray(nums, a, b, c);
	
    }    
}

