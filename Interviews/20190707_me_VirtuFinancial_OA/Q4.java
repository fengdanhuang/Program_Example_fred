import java.util.*;

public class Q4 {

    public int[] solution(int[] A) {
        if (A == null || A.length <= 2) return A;
        int[] re = Arrays.copyOf(A, A.length);

        boolean changed = false;
        while (true) {
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i - 1] > A[i] && A[i] < A[i + 1]) {
                    changed = true;
                    re[i]++;
                } else if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                    changed = true;
                    re[i]--;
                }
            }
            if (!changed) return re;
            changed = false;
            A = Arrays.copyOf(re, A.length);
        }
    }

    public void print(int[] A){
        for(int i=0; i<A.length; i++)
            System.out.print(A[i] + "  ");
        System.out.println();
    }

    public static void main(String args[]){
        Q4 q = new Q4();
        
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
