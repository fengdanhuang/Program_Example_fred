

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


class Reader4{

    int read4(char[] buf){
    
        int i=1;
        while(i<=4 && buf[i] ){
            System.out.print(buf[i] + "  ");
            i++;
        }
        System.out.println();
        return i;

    }
}


public class Solution extends Reader4 {


    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;
    
    public int read(char[] buf, int n) {

        int counter = 0;
        
        while (counter < n) {

            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        
        return counter;
    }
   
    public static void main(String args[]){

        Solution s = new Solution();
        
        char[] buf = new char[]{'a','b','c'};
        int n = 1;
        s.read(buf, n);
    }
 
}
