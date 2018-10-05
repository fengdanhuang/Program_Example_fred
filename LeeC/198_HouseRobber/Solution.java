


class Solution {
    public int rob(int[] num) {
    
        int prevMax = 0;
    
        int currMax = 0;
    
        for (int x:num) {
        
            int temp = currMax;
        
            currMax = Math.max(prevMax + x, currMax);
        
            prevMax = temp;
    
        }
    
        return currMax;

    }
 
    public static void main(String args[]){
        Solution sol = new Solution();

        int[] num = new int[]{1,2,3,1};
        sol.rob(num);

        num = new int[]{2,7,9,3,1}
        sol.rob(num);

    }   
}
