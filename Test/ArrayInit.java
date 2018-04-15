
import java.util.HashSet;
import java.util.Set;

public class ArrayInit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		int n = 5;
		int[][] cache = new int[m][n];
		System.out.println("cache ="+cache);
		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(cache[i][j]+" ");
			}
			System.out.println();
		}
		
		Set<Integer> set = new HashSet<>();
		for (Integer s:set){
			System.out.print(s+" ");
		}
		
		System.out.println("set = " + set);	

	}

}
