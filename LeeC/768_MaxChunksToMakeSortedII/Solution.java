
import java.util.*;


class Solution {
    
     public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0, nonzero = 0;

        int[] expect = arr.clone();
        Arrays.sort(expect);

        for (int i = 0; i < arr.length; ++i) {
            int x = arr[i], y = expect[i];

            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0) nonzero--;
            if (count.get(x) == 1) nonzero++;

            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == -1) nonzero++;
            if (count.get(y) == 0) nonzero--;

            if (nonzero == 0) ans++;
        }
	
	System.out.println("count = " + count);
	
	System.out.println("ans = " + ans);
        return ans;
    }


    public static void main(String args[]){
        Solution s1 = new Solution();
	
        int[] arr = new int[]{5,4,3,2,1};
        s1.maxChunksToSorted(arr);	

	arr = new int[]{2,1,3,4,4};
	s1.maxChunksToSorted(arr);
    }
}
