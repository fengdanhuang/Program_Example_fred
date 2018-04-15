


class Solution{
    
    public int integerReplacement(int n) {
        System.out.println("\nn = " + n);
         
        int c = 0;
    
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                --n;
            } else {
                ++n;
            }
            System.out.println("    n = " + n + ",   c = " + c);
            ++c;
        }
        System.out.println("c = " + c + "\n");
        return c;
    }

    public static void main(String args[]){
        Solution s1 = new Solution();

        int n = 8;
        s1.integerReplacement(n);

        n = 7;
        s1.integerReplacement(n);
    }
}
