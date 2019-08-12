public class Q1 {

    public int solution(int x) {
        if(x < 0) return 0-x; //Corner case, when x<0, the step is 0-x.
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 1;
        if (a == x || b == x) return 0;//Corner case, when x is 0, or 1
        int c = fib(a, b); // Get a fibnacci number

        while (c <= x) {
            int diff = Math.abs(x - c);
            if (min > diff) {
                min = diff;
                a = b; //update a
                b = c; //update b
                c = fib(a, b); //get a new fibnacci number
            }
        }

        return Math.min(min, Math.abs(x - c));
    }
    public int fib(int a, int b) {
        return a + b;
    }

    public static void main(String[] args){
        Q1 q = new Q1();
        int x = 0;
        System.out.println(x + ", " + q.solution(x));
        x = 1;
        System.out.println(x + ", " + q.solution(x));
        x = 3;
        System.out.println(x + ", " + q.solution(x));
        x = 6;
        System.out.println(x + ", " + q.solution(x));
        x = 10;
        System.out.println(x + ", " + q.solution(x));
        x = 10000;
        System.out.println(x + ", " + q.solution(x));
        x = 1000000;
        System.out.println(x + ", " + q.solution(x));
        x = -10;
        System.out.println(x + ", " + q.solution(x));
        x = -10000;
        System.out.println(x + ", " + q.solution(x));

    }
}
