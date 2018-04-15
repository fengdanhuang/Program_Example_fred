


class Solution {
    
    public int maxChunksToSorted(int[] arr) {
	for (int i=0; i<arr.length; i++)
	    System.out.print(arr[i] + "  ");
	System.out.println();

        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }

	System.out.println("ans = " + ans);
        return ans;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] arr = new int[]{4,3,2,1,0};
	s1.maxChunksToSorted(arr);


    }

}
