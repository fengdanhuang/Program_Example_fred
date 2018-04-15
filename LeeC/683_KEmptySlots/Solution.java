


class Solution{
    
    public int kEmptySlots(int[] flowers, int k) {
        
        int[] days =  new int[flowers.length];
        
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        
        for(int i = 0; right < days.length; i++){
            
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right) res = Math.min(res, Math.max(days[left], days[right]));   
                left = i; 
                right = k + 1 + i;
            }
            
        }
        
        //return (res == Integer.MAX_VALUE)?-1:res;
    	System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
	if (res == Integer.MAX_VALUE) return -1;
	else return res;
    }
    

    public static void main(String args[]){
	
	int flowers[] = {1,3,2};
	int k = 1;
	Solution s1 = new Solution();
	int output = s1.kEmptySlots(flowers, k);
	System.out.println("output = " + output);	

	flowers = new int[]{1,2,3};
	output = s1.kEmptySlots(flowers, k);
	System.out.println("output = " + output);	
		
    }    
}
