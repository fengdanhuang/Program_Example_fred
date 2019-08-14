import java.util.*;

public class Q4_2 {

    public int[] solution(int[] A) {
        if (A == null || A.length <= 2) return A;
        int[] re = Arrays.copyOf(A, A.length);

        boolean[] changed = new boolean[A.length];
        boolean stop;

        while (true) {
            stop = true;
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i - 1] > A[i] && A[i] < A[i + 1]) {
                    changed[i] = true;
                    re[i]++;
                } else if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                    changed[i] = true;
                    re[i]--;
                }
            }
            for (int i = 0; i < A.length; i++) {
                if (changed[i] == true) {
                    stop = false;
                }
            }

            if (stop) return re;
            for (int i = 0; i < changed.length; i++) {
                changed[i] = false;
            }

            A = Arrays.copyOf(re, A.length);
        }
    }

    public void print(int[] A){
        for(int i=0; i<A.length; i++)
            System.out.print(A[i] + "  ");
        System.out.println();
    }

    public static void main(String args[]){
        Q4_2 q = new Q4_2();

        int[] A = new int[]{1, 6, 3, 4, 3, 5};
        int[] B = q.solution(A);
        q.print(A);
        q.print(B);
        
	A = new int[]{100, 50, 40, 30};
        B = q.solution(A);
        q.print(A);
        q.print(B);
    }
}
