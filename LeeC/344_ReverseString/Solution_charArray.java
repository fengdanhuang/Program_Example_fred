


class Solution_charArray {
    
    public String reverseString(String s) {
       
        System.out.println("s = " + s); 
        char[] c = s.toCharArray();
        
        int i = 0;
        
        int j = c.length-1;
        
        while(i<j){
            char tem = c[i];
            c[i] = c[j];
            c[j] = tem;
            i++;
            j--;
        }
        
        String re = new String(c);
        
        System.out.println("re = " + re + "\n");
        return re;

 
        
    }


    public static void main(String args[]){
        Solution s = new Solution();

        String str = "hello";
        s.reverseString(str);

        str = "A man, a plan, a canal: Panama";
        s.reverseString(str);

    }
}
