


public class Solution {
    
    public String reverseWords(String s) {
        System.out.println("s = " + s);
 
        if (s == null || s.length() == 0) return "";
        
        s.trim();
        System.out.println("s = " + s);
        
        StringBuilder sb = new StringBuilder();
        
        int end = s.length()-1;
        
        while (end >= 0) {
            
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            
            int idx = s.lastIndexOf(' ', end);
            System.out.println("    idx = " + idx);
 
            sb.append(s.substring(idx + 1, end + 1)).append(' ');
            System.out.println("    sb = " + sb);

            end = idx - 1;
            
        }
        
        String re = sb.toString().trim();
        System.out.println("re = " + re);
        return re;
    }

    public static void main(String args[]){
        Solution sol = new Solution();

        String s = "   the sky is blue   ";
        sol.reverseWords(s);   
    }
 
}
