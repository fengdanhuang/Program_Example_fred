

class Solution_Self{
 
    public String reverseWords(String s) {
        // "\\s+" is regex representing that more than one space.
        System.out.println("s = " + s);

        String[] strs = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=strs.length-1; i>=0; i--){
            sb.append(strs[i]).append(" ");
            System.out.println("    sb = " + sb);
        }
        
        String tem = sb.toString();
        String re = tem.trim();
        
        System.out.println("re = " + re);
        return re;
        
    }


    public static void main(String args[]){
        Solution_Self ss = new Solution_Self();

        String s = "the sky is blue";
        ss.reverseWords(s);


    }


}
