


class Solution{


	public String reverseVowels(String s){
		System.out.println("s = " + s);
			
		if (s == null || s.length() == 0) return s;
		
		String vowels = "aeiouAEIOU";
		
		char[] array = s.toCharArray();
		
		int start = 0;
		int end = s.length() - 1;
		
		while(start < end){
			while(start < end && vowels.indexOf(array[start]) == -1){
				start++;
			}
			while(start < end && vowels.indexOf(array[end]) == -1){
				end--;
			}
			char tem = array[start];array[start]=array[end];array[end]=tem;
			start++;
			end--;
		}
		String re = String.valueOf(array);
		System.out.println("re = " + re + "\n");
		return re;
	}

	public static void main(String args[]){
		Solution s1 = new Solution();
		
		String s = new String("Leetcode");
		s1.reverseVowels(s);

		s = new String("hello");
		s1.reverseVowels(s);
	}

}
