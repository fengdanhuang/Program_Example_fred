
import java.util.*;


class Solution {
    //follow the highest voted post
    //
    
    //total time complexity? N * 2 ^ N?
    //can we optimize the complexity since the string operation is expensive
    //you should also be able to write BFS and simplied version(two pass, one pass)
    
    public List<String> removeInvalidParentheses(String s) {
        System.out.println("s = " + s);
         
        List<String> res = new ArrayList<>();
        
        removeHelper(s, res, 0, 0, '(', ')');
        
        System.out.println("res = " + res);
        return res;
    }
    
    private void removeHelper(String s, List<String> res, int start, int lastRemove, char plusChar, char minusChar){
        
        int count = 0;
        
        for (int i = start; i < s.length(); i++){
            if (s.charAt(i) == plusChar) count++;
            if (s.charAt(i) == minusChar) count--;
            
            if (count < 0){
                
                for (int j = lastRemove; j <= i; j++){
                    if (s.charAt(j) == minusChar && (j == lastRemove || s.charAt(j) != s.charAt(j - 1))){
                        removeHelper(s.substring(0, j) + s.substring(j + 1), res, i, j, plusChar, minusChar);
                    }
                }
                return; //should be return here, since the previous part has no wrong minusChar
            }
        }
        
        if (plusChar == '(' && count == 0){
            res.add(s);
            return;
        }
        
        StringBuilder sb = new StringBuilder(s);
        
        String reversedS = sb.reverse().toString();
        
        if (plusChar == '('){
            removeHelper(reversedS, res, 0, 0, ')', '(');
        } else {
            res.add(reversedS);
        }
        
    }


    public static void main(String args[]){
        
        Solution s = new Solution();
        
        String str = "()())()";
        s.removeInvalidParentheses(str);

        str = "(a)())()";
        s.removeInvalidParentheses(str);

        str = ")("; 
        s.removeInvalidParentheses(str);
    }
}
