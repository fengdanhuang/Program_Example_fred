


// Java program for implementation of Heap Sort
public class HeapSort{

    public void sort(int arr[]){
        int n = arr.length;
	for(int i=0; i<n; i++)
	    System.out.print(arr[i] + "  ");
	System.out.println();
 
        // Build heap (rearrange array)
	System.out.println("n = " + n);
	System.out.println("n/2 = " + n/2);
        for (int i = n/2-1; i >= 0; i--){
	    System.out.println("    heapify(arr," + n + "," + i + ")");
            heapify(arr, n, i);
	}
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--){
            // Move current root to end
            int temp = arr[0];arr[0] = arr[i];arr[i] = temp; 
            // call max heapify on the reduced heap
	    System.out.println("    heapify(arr," + i + "," + 0 + ")");
            heapify(arr, i, 0);
        }

	for(int i=0; i<n; i++)
	    System.out.print(arr[i] + "  ");
	System.out.println("\n");
    }
 
    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i){
	
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
	System.out.println("        largest = " + largest + ", l = " + l + ", r = " + r);
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i){
            int swap = arr[i];arr[i] = arr[largest];arr[largest] = swap;
            // Recursively heapify the affected sub-tree
	    System.out.println("        heapify(arr," + n + "," + largest + ")");
            heapify(arr, n, largest);
        }

    }
  
    public static void main(String args[]){
        HeapSort ob = new HeapSort();
        
	int arr[] = new int [] {12, 11, 13, 5, 6, 7}; 
        ob.sort(arr); 
    
	arr = new int [] {1,5,3,6,7,100,0,-20, 75,66,80};
	ob.sort(arr);

    }

}
