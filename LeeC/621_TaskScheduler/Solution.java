
import java.util.*;


class Solution{

	public int leastInterval(char[] tasks, int n) {
        	for(int i=0; i<tasks.length; i++)
			System.out.print(tasks[i] + "  ");
		System.out.println();
		
		int[] map = new int[26];
                for(int i=0; i<map.length; i++)
                    System.out.print(map[i] + "  ");
                System.out.println();
        	
		for (char c: tasks)
            		map[c - 'A']++;
        	
                for(int i=0; i<map.length; i++)
                    System.out.print(map[i] + "  ");
                System.out.println();


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

        public int leastInterval2(char[] tasks, int n) {
        
            int[] map = new int[26];
        
            for (char c: tasks) map[c - 'A']++;
        
            Arrays.sort(map);
        
            int max_val = map[25] - 1, idle_slots = max_val * n;
        
            for (int i = 24; i >= 0 && map[i] > 0; i--) {
                idle_slots -= Math.min(map[i], max_val);
            }
        
            int re;
            if (idle_slots>0){
                re = idle_slots + task.length;
            }else{
                re = task.length;
            }
        
            return re;
        
        }
    
	public static void main(String args[]){
		Solution s1 = new Solution();

		char[] tasks = new char[] {'A','A','A','B','B','B'};
		int n = 2;
		s1.leastInterval(tasks, n);	
	        s1.leastInterval2(tasks, n);
	}
}

