
/*

Interviwer: HK (White Old Man)

Question 1:

Given a array, very long, could be billions. A[i] = i. 
Then starting at some point, A[i] = i-1, then the repetition happend.
Find the starting point that the repetition happened.


*/


/*
My idea: 
Use binary search.
long low = 0;
long high = a.length-1;
long mid = low + (high-low)/2;

while (low <= high){

    if (target = a[mid]) return;
    else if(target < a[mid) high = mid -1;
    else low = mid + 1;
}
*/

public class FindMidPoint{

    public int findMidPoint(int[] a){

    }

    public static void main(String[] args){

    }

}

