

public class Solution {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return dfs(maze, start, destination, visited);
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
	System.out.print("dfs(  ");
	System.out.print("start=(");
	for(int i=0;i<start.length;i++)
	    System.out.print(start[i]+"  ");
	System.out.print("), ");
	System.out.print("end=(");
	for(int i=0;i<destination.length;i++)
	    System.out.print(destination[i]+"  ");
	System.out.print("),  ");
	System.out.println(")");

        
        if (visited[start[0]][start[1]])
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        
	visited[start[0]][start[1]] = true;
        
	int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
        
	if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
            return true;
        
	while (l >= 0 && maze[start[0]][l] == 0) //left
            l--;
        
	if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
            return true;
        
	while (u >= 0 && maze[u][start[1]] == 0) //up
            u--;
        
	if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
            return true;
        
	while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;
        
	if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
            return true;
        
	return false;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[][] maze = new int[][]{{0,0,1,0,0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{1, 1, 0, 1, 1},{0, 0, 0, 0, 0}};
	int[] start = new int[]{0,4};
	int[] end = new int[]{4,4};
	s1.hasPath(maze, start, end);
	
    }	
	
 
    
}
