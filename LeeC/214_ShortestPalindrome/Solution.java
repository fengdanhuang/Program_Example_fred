

class Solution{
       
    public String shortestPalindrome(String s) {
        System.out.println("s = " + s);    

        int i = 0;
        int end = s.length()-1;
        int j = end; 

        char chs[] = s.toCharArray();
    
        while(i < j) {
         
            if (chs[i] == chs[j]) {
             
                i++; j--;
         
            } else { 
             
                i = 0; end--; j = end;
         
            }
        }
   
        String sub = s.substring(end+1);
        System.out.println("sub = " + sub); 

        StringBuilder sb = new StringBuilder(sub);
        System.out.println("sb = " + sb);
      
        String re = sb.reverse().toString() + s;
        System.out.println("re = " + re + "\n");

        return re;
        
    }
     
    public static void main(String args[]){
        Solution sol = new Solution();

        String s = "aacecaaa";
        sol.shortestPalindrome(s);

        s = "abcd";
        sol.shortestPalindrome(s);
    }   
}
