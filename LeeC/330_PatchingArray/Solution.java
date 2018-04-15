


public class Solution {
    
    public int minPatches(int[] nums, int n) {
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();
	System.out.println("n = " + n);

        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }

	System.out.println("patches = " + patches + "\n");
        return patches;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int[]{1, 3};
	int n = 6;
	s1.minPatches(nums, n);

	nums = new int[]{1, 5, 10};
	n = 20;
	s1.minPatches(nums, n);
	

    }
}
