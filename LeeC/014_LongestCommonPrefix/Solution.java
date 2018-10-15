


class Solution {
    
     public String longestCommonPrefix_HS(String[] strs) {
    
         if (strs.length == 0) return "";

         for(int i=0; i<strs.length; i++)
             System.out.print(strs[i] + "  ");
         System.out.println();
    
         String prefix = strs[0];
    
         for (int i = 1; i<strs.length; i++){
        
             while (strs[i].indexOf(prefix) != 0) {
            
                 prefix = prefix.substring(0, prefix.length()-1);
            
                 if (prefix.isEmpty()) return "";
        
             } 
         }
         
         System.out.println("prefix = " + prefix); 
         return prefix;

     }

     public static void main(String args[]){
         
          Solution sol = new Solution();
         
          String[] strs = new String[]{"flower","flow","flight"};
          sol.longestCommonPrefix_HS(strs);   

          strs = new String[]{"dog","racecar","car"};
          sol.longestCommonPrefix_HS(strs);   

     }    
}
