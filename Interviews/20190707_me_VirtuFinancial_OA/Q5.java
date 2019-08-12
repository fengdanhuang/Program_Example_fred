public class Q5 {
    
    public int solution(String s) {
        int cnt = 0;
        if (s == null || s == "") return cnt;
        cnt = s.length(); //First get all single char cnt.
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) 
            for (int j = i + 1; j < cs.length; j++) 
                if (cs[i] == cs[j]) cnt++;
                else break;
        return cnt;
    }

    public static void main(String[] args){
        Q5 q = new Q5();
        String s = "zzzyz";
        System.out.println(s + ": " + q.solution(s));
    }    

}
