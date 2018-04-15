


class Solution {
    
    public int[] plusOne(int[] digits) {
	for(int i=0; i<digits.length; i++)
		System.out.print(digits[i] + "  ");
	System.out.println();
	 
        int n = digits.length;
        
        for(int i=n-1; i>=0; i--) {
            
            if(digits[i] < 9) {
                
                digits[i]++;

		for(i=0; i<digits.length; i++)
			System.out.print(digits[i] + "  ");
		System.out.println("\n");
                return digits;
            }
        
            digits[i] = 0;
        }
    
        int[] newNumber = new int [n+1];
	for(int i=0; i<newNumber.length; i++)
		System.out.print(newNumber[i] + "  ");
	System.out.println(); 

        newNumber[0] = 1;
   
	for(int i=0; i<newNumber.length; i++)
		System.out.print(newNumber[i] + "  ");
	System.out.println("\n"); 
        return newNumber;
        
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] digits = new int[]{0};
	s1.plusOne(digits);

	digits = new int[]{1,3,5,6,7};
	s1.plusOne(digits);

	digits = new int[]{9,9,9,9};
	s1.plusOne(digits);

	digits = new int[]{1,0,9,9};
	s1.plusOne(digits);
    }

}
