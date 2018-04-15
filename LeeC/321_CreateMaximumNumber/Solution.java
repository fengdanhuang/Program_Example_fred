


class Solution{

    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        
        int m = nums1.length;
        int n = nums2.length;
        int[] re = new int[k];
        for(int i=Math.max(0, k-n); i<=k && i<=m; i++){
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
	    if (greater(temp, 0, re, 0)){
	        re = temp;
	    }	
        }
    }

    private int[] merge(int[] nums1, int[] nums2, int k){
	int[] re = new int[k];
	for (int i=0, j=0, r=0; r<k; r++){
	   re[r] = greater(nums1, i, nums2, j)? nums1[i++]: nums2[j++];
	}
	return re;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j){
	while (i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
	    i++;
	    j++;
	}
	return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }

    private int[] maxArray(int[] nums, int k){
	int n = nums.length;
	int[] res = new int[k];
	for(int i=0, j=0; i<n; i++){
	    while (n-i>k-j && j>0 && nums[i] > res[j-1]){
	        j--;
	    }
	    if (j<k){
	        res[j++] = nums[i];
	    }
	}
	return re;
    }
	




    public static void main(String args[]){
	Solution s1 = new Solution();

        int[] nums1 = new int[]{3, 4, 6, 5};
	int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
	int k = 5;
	s1.maxNumber(nums1, nums2, k); 

	nums1 = new int[]{6, 7};
	nums2 = new int[]{6, 0, 4};
	k = 5;
	s1.maxNumber(nums1, nums2, k); 
	
    }

}
