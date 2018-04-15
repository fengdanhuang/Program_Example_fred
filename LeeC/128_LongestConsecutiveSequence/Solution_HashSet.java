
import java.util.*;


class Solution_HashSet {

    public int longestConsecutive(int[] nums) {
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();

        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int re = 0;
        for(int num: nums){
            set.add(num);
        }
        for(int i=0; i<nums.length; i++){
            int down = nums[i]-1;
            while(set.contains(down)){
                set.remove(down);
                down--;         
            }
            int up = nums[i]+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            re = Math.max(re, up-down-1);
            
        }

	System.out.println("re = " + re);
        return re;
    }


    public static void main(String args[]){
	Solution_HashSet sh = new Solution_HashSet();

	int[] nums = new int[]{100, 4, 200, 1, 3, 2};
	sh.longestConsecutive(nums);
    }
}
