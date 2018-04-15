


class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
	for (int i=0; i<matrix.length; i++){
	    for (int j=0; j<matrix[0].length; j++){
	        System.out.print(matrix[i][j] + "  ");
	    }
	    System.out.println();
	}

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
	        System.out.println("        matrix.length - 1 = " + (matrix.length-1));
		System.out.println("        matrix[i].length - 1 = " + (matrix[i].length-1));
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[][] matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
	s1.isToeplitzMatrix(matrix);

	matrix = new int[][]{{1,2},{2,2}};
	s1.isToeplitzMatrix(matrix);
    }
	
}
