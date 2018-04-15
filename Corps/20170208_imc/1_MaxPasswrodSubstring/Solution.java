


class Solution{


	public int solution(String s){
	
		int re = 0; j = 0;

		boolean B = false;
		
		if (s == null || s.length() == 0) return -1;
	
	 	for(int i=0; i<s.length(); i++){
			while (s.charAt(i)<'0' && s.charAt(i)>'9'){
				j = i;	
				j++;
				re = Math.max(re, j-i+1);

			}
			
			j = i;
		}



	
		return re;
	}


	public static void main(String args[]){
		Solution s1 = new Solution();

		String s = new String("a0Ba");
		s1.solution(s);

	}


}
