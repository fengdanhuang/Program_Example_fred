
class ArrayPositions{

	public static void main (String argv[]){
		int i;
		int[] aiEvens = new int[4];
	
		for (i = 0; i< aiEvens.length; i++){
			aiEvens[i] = i*2;
			System.out.println( i + ":= " + aiEvens[i]);
		}
	}
}

