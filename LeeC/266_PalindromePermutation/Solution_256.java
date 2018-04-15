


class Solution_256 {
    public boolean canPermutePalindrome(String s) {
        char[] count = new char[256];
        int re = 0;
        boolean bRe;
        for (char c: s.toCharArray()){
            if (count[c] > 0){
                count[c]--;
            }else if (count[c] == 0){
                count[c]++;
            }
        }
        for(int i=0; i<count.length; i++){
            if(count[i]!=0) re++;
        }
        if(re<=1){
            bRe = true;
        }else{
            bRe = false;
        }
        
        return bRe;
    }

    public static void main(String args[]){

    }
}
