public class Q3 {

    public String solution(String s) {
        long l = Long.parseLong(s);
        String hex = Long.toHexString(l).toUpperCase();
        String allow = "ABCDEFIO10";
        for (char c : hex.toCharArray()) {
            if (allow.indexOf(c) == -1 ) {
                return "ERROR";
            }
        }
        String re = hex.replaceAll("0", "O").replaceAll("1", "I");
        return re;
    }

    public static void main(String[] args){
        Q3 q = new Q3();
        String s = "100";
        System.out.println(s + ": " + q.solution(s));

        s = "257";
        System.out.println(s + ": " + q.solution(s));
        
	s = "3";
        System.out.println(s + ": " + q.solution(s));
	
	s = "1000000000000";
        System.out.println(s + ": " + q.solution(s));
    }    
}
