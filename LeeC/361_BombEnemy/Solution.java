


public class Solution {
    
    public int maxKilledEnemies(char[][] grid) {
        
        int m = grid.length;
        
        int n = m != 0 ? grid[0].length : 0;
        
        int result = 0;
        
        int rowhits = 0;
        
        int[] colhits = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++)
                        rowhits += grid[i][k] == 'E' ? 1 : 0;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++)
                        colhits[j] += grid[k][j] == 'E' ? 1 : 0;
                }
                if (grid[i][j] == '0')
                    result = Math.max(result, rowhits + colhits[j]);
            }
        }
	for (int i=0; i<colhits.length; i++)
		System.out.print(colhits[i] + "  ");
	System.out.println();

	System.out.println("result = " + result);
        return result;
    }

    public static void main(String args[]){
	char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
	for(int i=0;i<grid.length;i++){
		for(int j=0;j<grid[0].length;j++){
			System.out.print(grid[i][j] + "  ");
		}
		System.out.println();
	}
	
	Solution s1 = new Solution();
	s1.maxKilledEnemies(grid);
	
    }
    
}
