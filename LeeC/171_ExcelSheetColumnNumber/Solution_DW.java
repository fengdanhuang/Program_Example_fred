


class Solution_DW{

    public int titleToNumber(String s) {
        
        char[] chs = s.toCharArray();
        
        int re = 0;
        
        for(int i=chs.length-1; i>=0; i--){
            
            int digit = chs[i]-'A'+1;
            re += digit * Math.pow(26, chs.length-i-1);
        }
        
        return re;
        
    }

    public static void main(String args[]){


    }

}
