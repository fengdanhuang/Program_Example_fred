//Question:
//Input:
//arr1 = {[1,2], [3,9]}
//arr2 = {[4,6], [8,10], [11,12]}
//
//Output = {[1,2], [3,10], [11,12]}
//
//merge(arr1, arr2) -> arr3

import java.util.*;

class Merge{
public int[][] merge(int[][] arr1, int[][] arr2){
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                System.out.print(arr1[i][j] + "  ");
            }
        }
        System.out.println("");
        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                System.out.print(arr2[i][j] + "  ");
            }
        }
        System.out.println("");
    int[] start = new int[arr1.length+arr2.length];
    int[] end = new int[arr1.length+arr2.length];
    for(int i=0; i < arr1.length; i++){
        start[i] = arr1[i][0];
        end[i] = arr1[i][1];
    }
    for(int i=0; i< arr2.length; i++){
        start[i+arr1.length] = arr2[i][0];
        end[i+arr1.length] = arr2[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int startIndex = 0, endIndex = 0;
    List<int[]> re = new ArrayList<>();
    while( endIndex < start.length){
        if(endIndex+1 == start.length || start[endIndex+1] > end[endIndex]){
            re.add(new int[]{start[startIndex], end[endIndex]});
            startIndex = endIndex+1;
        }
	endIndex++;
    }
    return re.toArray(new int[re.size()][]);
}
}

class Solution{
    public static void main(String args[]){
        Merge m = new Merge();
        int[][] arr1 = {{1,2}, {3,9}};
        int[][] arr2 = {{4,6}, {8,10}, {11,12}};
        int[][] arr3 = m.merge(arr1, arr2);
        System.out.println(" arr3 = ");
        for(int i=0; i<arr3.length; i++){
            for(int j=0; j<arr3[0].length; j++){
                System.out.print(arr3[i][j] + "  ");
            }
        }
        System.out.println("");
    }
}


 
