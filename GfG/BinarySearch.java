

// Java implementation of recursive Binary Search
class BinarySearch{

    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x){
	System.out.println("binarySearch(arr, " + l + "," + r + "," + x + ")");	

        if ( l<=r ){

            int mid = l + (r - l)/2;
	    System.out.println("    mid = " + mid);	 
            if (arr[mid] == x) return mid; 
            else if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);
 	    else if (arr[mid] < x) return binarySearch(arr, mid+1, r, x);
        }
 	return -1;
    }
 
    public static void main(String args[]){
        BinarySearch ob = new BinarySearch();

        int arr[] = new int[] {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
	for (int i=0; i<n; i++)
		System.out.print(arr[i] + "  ");
	System.out.println();
	System.out.println("x = " + x);
        int result = ob.binarySearch(arr,0,n-1,x);
        if (result == -1) System.out.println("Element not present");
        else System.out.println("Element found at index " + result);
	System.out.println();

    }

}
/* This code is contributed by Rajat Mishra */

