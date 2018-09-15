


class Solution {
    
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        
        System.out.println("num = " + num);      
  
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";
    
        while (num > 0) {
            int mod1000 = num % 1000;
            System.out.println("    mod1000 = " + mod1000);
            if (mod1000 != 0)
    	        words = helper(mod1000) + THOUSANDS[i] + " " + words;
    	    num /= 1000;
    	    i++;
        }
    
        String re = words.trim();
        System.out.println("re = " + re + "\n");
        return re;
    }

    private String helper(int num) {
        
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        
    }


    public static void main(String args[]){

        Solution s = new Solution();
        
        int i = 123;
        s.numberToWords(i);

        i = 12345;
        s.numberToWords(i);

        i = 1234567;
        s.numberToWords(i);
        
        i = 1234567891;
        s.numberToWords(i);
    }
    
}
