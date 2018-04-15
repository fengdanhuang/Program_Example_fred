


class Solution {
    
    public int findLonelyPixel(char[][] picture) {
	for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
		System.out.print(picture[i][j] + " ");
	    }
	    System.out.println();
	}   
 
        int n = picture.length, m = picture[0].length;
    
        int[] rowCount = new int[n], colCount = new int[m];
    
        for (int i=0;i<n;i++) 
            for (int j=0;j<m;j++) 
                if (picture[i][j] == 'B') { rowCount[i]++; colCount[j]++; }

	for (int i=0; i<n; i++)
  	    System.out.print(rowCount[i] + "  ");
	System.out.println();

	for (int j=0; j<m; j++)
	    System.out.println(colCount[j]);

        int count = 0;
        for (int i=0;i<n;i++) 
            for (int j=0;j<m;j++) 
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;
               
	System.out.println("count = " + count); 
        return count;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	char[][] picture = new char[][]{{'W', 'W', 'B'},{'W', 'B', 'W'},{'B', 'W', 'W'}};
        s1.findLonelyPixel(picture);

    }

}
