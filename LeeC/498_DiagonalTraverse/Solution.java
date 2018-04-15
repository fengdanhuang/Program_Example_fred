



class Solution {
    
    public int[] findDiagonalOrder(int[][] matrix) {
	for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + "  ");
	    }
	    System.out.println();
	}       
 
        if (matrix == null || matrix.length == 0) return new int[0];
        
        int m = matrix.length, n = matrix[0].length;
	System.out.println("m = " + m + ", n = " + n  + "\n");       
 
        int[] result = new int[m * n];
	for(int i=0; i<result.length; i++)
	    System.out.print(result[i] + "  ");
	System.out.println(); 
        
        int row = 0, col = 0, d = 0;
        
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for (int i = 0; i < m * n; i++) {
	    System.out.println("\ni = " + i);
            System.out.println("row = " + row + ", col = " + col + ", d = " + d);
            
	    result[i] = matrix[row][col];
            System.out.println("result[" + i + "]=" + "matrix[" + row + "][" + col + "];");
	    
            row += dirs[d][0];
            col += dirs[d][1];
    
            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }
       
	for(int i=0; i<result.length; i++)
	    System.out.print(result[i] + "  ");
	System.out.println(); 
        return result;
    }

    public static void main(String args[]){
        Solution s1 = new Solution();

	int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	s1.findDiagonalOrder(matrix);


    }
}
