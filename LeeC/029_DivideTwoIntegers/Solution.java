


class Solution {
    
    public int divide(int dividend, int divisor) {
       
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
 
        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        
        if(divisor==-1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long)dividend);
        
        long pDivisor = Math.abs((long)divisor);

        System.out.println("pDividend = " + pDividend);
        System.out.println("pDivisor = " + pDivisor);
  
        int result = 0;
        
        while(pDividend>=pDivisor){
            
            //calculate number of left shifts
            int numShift = 0;   
            
                           
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            System.out.println("result = " + result + "\n");
            return result;
        }else{
            System.out.println("result = " + result + "\n");
            return -result;
        }
        
    }

    public int divide_wrong(int dividend, int divisor){
        int result2 = dividend /divisor;
        System.out.println("result2 = " + result2 + "\n");
        
        return result2;
    }

    public static void main(String args[]){
        
        Solution s = new Solution();
        
        int dividend = 10, divisor = 3;
        s.divide(dividend, divisor);
        
        dividend = 7; divisor = -3;
        s.divide(dividend, divisor);

        dividend = -2147483648; divisor = -1;
        s.divide(dividend, divisor);
        s.divide_wrong(dividend, divisor);
    }

}
