
import java.util.*;


class Solution{

	public int leastInterval(char[] tasks, int n) {
        	for(int i=0; i<tasks.length; i++)
			System.out.print(tasks[i] + "  ");
		System.out.println();
		
		int[] map = new int[26];
        	
		for (char c: tasks)
            		map[c - 'A']++;
        	
		Arrays.sort(map);
        	int time = 0;
        	while (map[25] > 0) {
            		int i = 0;
            		while (i <= n) {
                		if (map[25] == 0)
                    			break;
                		if (i < 26 && map[25 - i] > 0)
                    			map[25 - i]--;
                		time++;
                		i++;
            		}
            		Arrays.sort(map);
        	}


		System.out.println("time = " + time);		
        	return time;
    	}

    
	public static void main(String args[]){
		Solution s1 = new Solution();

		char[] tasks = new char[] {'A','A','A','B','B','B'};
		int n = 2;
		s1.leastInterval(tasks, n);	
	
	}
}

