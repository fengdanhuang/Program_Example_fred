

class Solution {

    public int solution(String S) {
        // write your code in Java SE 8
        if(S==null || S.length()==0)
            return 0;
        
        int res = 0;
        
      
        for(int i=0;i<S.length();i++)
        {
            if(Character.isUpperCase(S.charAt(i)))
            {
                res = Math.max(findLength(i,S),res);   
            }else{
	        res = -1;
	    }    
        }
	System.out.println("res = " + res);
        return res;
    }
    
    private int findLength(int index,String S)
    {
        char[] ch = S.toCharArray();
        int start = index-1,end = index+1;
        while(start>=0 || start<S.length())
        {
            if(Character.isDigit(ch[start]) && Character.isDigit(ch[end]) )
                break;
            
            if(start>=0)
            {
                if(!Character.isDigit(ch[start]))
                    start--;
                else
                    continue;
            }
            
             if(end<ch.length)
            {
                if(!Character.isDigit(ch[end]))
                    end++;
                else
                    continue;
            }
        }
        return end-start+1;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();
	
	String s = new String("a0bb");
	s1.solution(s);

	s = new String("a0Ba");
	s1.solution(s);

	s = new String("0aabbccbdddBc2a");
	s1.solution(s);

    }
}
