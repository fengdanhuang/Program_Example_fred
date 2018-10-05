


public class Solution {
    
    public int maxArea(int[] height) {
        
        int maxarea = 0;
        int l = 0;
        int r = height.length-1;
        
        while (l < r) {
            
            int minlr = Math.min(height[l], height[r]);
            
            int curarea = minlr * (r-l);
            
            maxarea = Math.max(maxarea, curarea);
            
            if (height[l] < height[r]) l++;
            else r--;
            
        }
        
        return maxarea;
        
    }
 
    public static void main(String args[]){


    }

   
}
