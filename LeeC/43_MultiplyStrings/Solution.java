


class Solution {
    
    public String multiply(String num1, String num2) {
         
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    
        int m = num1.length(), n = num2.length();
        
        int[] pos = new int[m + n];
	for (int i = 0; i<m+n; i++)
		System.out.println("pos[i] = "+ pos[i]);


   
        for(int i = m - 1; i >= 0; i--) {
            
            for(int j = n - 1; j >= 0; j--) {
                
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
		System.out.println("mul = " + mul); 
                
                int p1 = i + j, p2 = i + j + 1;
                
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                
                pos[p2] = (sum) % 10;
                
            }
        }  
    
        StringBuilder sb = new StringBuilder();
        
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        
        return sb.length() == 0 ? "0" : sb.toString();
        
    }

    
    public static void main(String args[]){
	Solution s1 = new Solution();
	s1.multiply("123","234");
    }
    
}
