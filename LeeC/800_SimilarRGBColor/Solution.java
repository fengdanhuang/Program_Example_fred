

class Solution {

    public String similarRGB(String color) {
	System.out.println("\ncolor = " + color);
	System.out.println("color.length() = " + color.length());


        StringBuilder sb = new StringBuilder(color.length());
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2){
            sb.append(getHexDigits(color.charAt(i), color.charAt(i + 1)));
        }

	String re = sb.toString();
	System.out.println("re = " + re + "\n");
        return re;
    }

    private String getHexDigits(char c1, char c2){
	System.out.println("c1 = " + c1);
	System.out.println("c2 = " + c2);


        int d1 = Character.isDigit(c1)? c1 - '0': 10 + c1 - 'a';
        int d2 = Character.isDigit(c2)? c2 - '0': 10 + c2 - 'a';
	System.out.println("d1 = " + d1);
	System.out.println("d2 = " + d2);    

        int sum       = d1 * 16 + d2;
	System.out.println("sum = " + sum);
        int index     = sum / 17; // [ 0x00(0) , 0x11(17), 0x22(34),  0x33(51), ........., 0xff(255) ]
        System.out.println("index = " + index);
	int remainder = sum % 17;
	System.out.println("remainder = " + remainder);
        if (remainder > 17 / 2){
            index++;
        }
    
        char c = 0 <= index && index <= 9? (char)('0' + index): (char)('a' + index - 10);
        return String.valueOf(c) + String.valueOf(c);
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String color = "#09f166";
	s1.similarRGB(color);

    }
}
