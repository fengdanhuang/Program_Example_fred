


class Solution {
    
    public boolean validPalindrome(String s) {
        System.out.println("s = " + s);
         
        char[] sc = s.toCharArray();
        
        int start = 0;
        int end = s.length() - 1;
        System.out.println("start = " + start);
        System.out.println("end = " + end);
 
        int diff = 0;
        
        int count;
             
        count = isPal(sc, start, end, diff);
       
        boolean re; 
        if(count == 0 || count == 1) re = true; 
        else re = false;

        System.out.println("re = " + re + "\n");
        return re;
        
    }

    private int isPal(char[] sc, int start, int end, int diff) {
        
        System.out.println("isPal(sc," + start + "," + end + "," + diff + ")" );      
 
        if (start > end || diff > 1) return -1;

        while (start <= end && sc[start] == sc[end]) {
            start++;
            end--;
        }

        if (start > end) {
            
            return 0;
            
        } else {
            
            int left = isPal(sc, start + 1, end, diff + 1);
            int right = isPal(sc, start, end - 1, diff + 1);
            
            return (left == 0 || right == 0) ? 0 : -1;
            
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String str = "aba";
        s.validPalindrome(str);

        str = "abca";
        s.validPalindrome(str);
    }
}
