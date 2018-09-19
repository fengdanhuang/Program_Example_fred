



class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
       
        System.out.println("s = " + s);
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println();


 
        int startPtr = 0;
        
        int endPtr = 0;
        
        int minLength = Integer.MAX_VALUE;

        int curTotal = 0;
        
        for (int i=0; i< nums.length; i++) {
            
            curTotal += nums[i];
            endPtr++;
            
            while (curTotal >= s) {
                
                curTotal -= nums[startPtr];
                startPtr++;
                
                if (endPtr - startPtr + 1 < minLength) {
                    minLength = endPtr - startPtr + 1;
                    System.out.println("    minLength = " + minLength);    
                }
            }
            
        }
        
        if( minLength == Integer.MAX_VALUE ){
            minLength = 0;
        }
        
        System.out.println("minLength = " + minLength);    
        return minLength;
        
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();
        
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        sol.minSubArrayLen(s, nums);

    }
}
