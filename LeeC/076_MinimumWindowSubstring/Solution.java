



class Solution {
    
    public String minWindow(String s, String t) {
        System.out.println("s = " + s);
        System.out.println("t = " + t);       
 
        int lens = s.length();
        int lent = t.length();
        int[] cnt = new int[128];
        
        for (int i=0; i<128; ++i) cnt[i]=0;
        
        for (char c : t.toCharArray()) ++cnt[c];
        
        int left=0,right=0,minleft=0,minlen=lens+1,count=0;
        
        for (right=0; right<lens; ++right){
            
            char c = s.charAt(right);
            --cnt[c];
            if (cnt[c]>=0) ++count;
            
            while (count==lent){
                
                if (right-left+1<minlen){
                    minlen = right-left+1;
                    minleft = left;
                }
                c = s.charAt(left);
                ++cnt[c];
                if (cnt[c]>0) --count;
                ++left;
                
            }
            
        }
       
        String re = new String();
        if ( minlen > lens ){
            re = "";
        }else{
            re = s.substring(minleft, minleft + minlen);
        } 
        System.out.println("re = " + re);
        return re;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String S = "ADOBECODEBANC";
        String T = "ABC";
        s.minWindow(S, T);

    }
}
