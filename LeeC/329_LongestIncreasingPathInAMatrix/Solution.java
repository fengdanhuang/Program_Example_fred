


class Solution {
    
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
    
        if(matrix.length == 0) return 0;
        
  	int m = matrix.length, n = matrix[0].length;
    
	int[][] cache = new int[m][n];
    
	int max = 1;
    
	for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
		System.out.println("    max = " + max);
            }
        }  
	System.out.println("max = " + max); 
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    
	if(cache[i][j] != 0){ 
	    System.out.println("        cache["+i+"]["+j+"]="+cache[i][j]);
	    return cache[i][j];
    	}
	int max = 1;
    
	for(int[] dir: dirs) {
	    
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
    	cache[i][j] = max;
    	
	System.out.println("        max = " + max);
	return max;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
	s1.longestIncreasingPath(matrix);

	matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
	s1.longestIncreasingPath(matrix);
    } 
    
}
