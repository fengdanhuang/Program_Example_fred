
import java.util.*;

class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        if (matrix.length == 0) return ans;
        
        int R = matrix.length, C = matrix[0].length;
        
        boolean[][] seen = new boolean[R][C];
        
        int[] dr = {0, 1, 0, -1};
        
        int[] dc = {1, 0, -1, 0};
        
        int r = 0, c = 0, di = 0;
        
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
       
	for (Integer a:ans){
		System.out.println(a+" ");
		System.out.println();
	} 
        return ans;
    }

    public static void main(String args[]){

	Solution s1 = new Solution();

	int[][] matrix = {{1,2,3},
			  {4,5,6},
			  {7,8,9}};	
	s1.spiralOrder(matrix);
    }
    
}
