


/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

class GuessGame{

    public int guess(int n){
	System.out.println("    guess(" + n + ")");
	int picked = 6;
	if(picked<n){ 
	    System.out.println("    My number is lower.");
	    return -1;
	}else if (picked>n){ 
	    System.out.println("    My number is higher.");
	    return 1;
	}else{
	    System.out.println("    Congrats! You got it!");
	    return 0;
	}
    }
}


class Solution extends GuessGame {
    
    public int guessNumber(int n) {
	System.out.println("guessNumber(" + n + ")");       
 
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
	    System.out.println("    mid = " + mid);
            int res = guess(mid);

            if (res == 0) return mid;
            else if (res < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
        
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	int n = 10;
	s1.guessNumber(n);

    }
    

}
