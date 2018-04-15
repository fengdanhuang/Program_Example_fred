
import java.util.*;



class Solution {
    
    private static final int EMPTY = Integer.MAX_VALUE;
    
    private static final int GATE = 0;
    
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
	for(int i=0; i<rooms.length; i++){
	    for(int j=0; j<rooms[0].length; j++)
		System.out.print(rooms[i][j] + "  ");
	    System.out.println();	
	}
	System.out.println("\n");	

        int m = rooms.length;
        if (m == 0) return;
        
	int n = rooms[0].length;
        
	Queue<int[]> q = new LinkedList<>();
        
	for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
	System.out.println("q = " + q);

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }

	System.out.println("q = " + q);

	for(int i=0; i<rooms.length; i++){
	    for(int j=0; j<rooms[0].length; j++)
		System.out.print(rooms[i][j] + "  ");
	    System.out.println();	
    	}
	System.out.println("\n");	
    }

    public static void main(String args[]){
	Solution s1 = new Solution();
	System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
	System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);

	int[][] rooms = new int[][]{{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
				    {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
				    {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
				    {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
	s1.wallsAndGates(rooms);

    }
    
}
