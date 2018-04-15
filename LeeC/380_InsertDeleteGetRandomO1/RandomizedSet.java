
import java.util.*;


public class RandomizedSet {
    
    private Set<Integer> data;
    
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
	boolean re;
        if (data.contains(val))
	    re = false;
        data.add(val);
	re = true;

        System.out.println("insert re = " + re); 	
	return re;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
	boolean re;
        if (!data.contains(val))
	    re = false;
        data.remove(val);
	re = true;
        
	System.out.println("remove re = " + re); 	
	return re;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(data.size());
        Integer[] dt = data.toArray(new Integer[0]);
	
	for(int i=0; i<dt.length; i++)
	    System.out.print(dt[i] + "  ");
	System.out.println();

        return dt[index];
    }

    public static void main(String args[]){
	// Init an empty set.
	RandomizedSet randomSet = new RandomizedSet();

	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
	randomSet.insert(1);

	// Returns false as 2 does not exist in the set.
	randomSet.remove(2);

	// Inserts 2 to the set, returns true. Set now contains [1,2].
	randomSet.insert(2);

	// getRandom should return either 1 or 2 randomly.
	randomSet.getRandom();

	// Removes 1 from the set, returns true. Set now contains [2].
	randomSet.remove(1);

	// 2 was already in the set, so return false.
	randomSet.insert(2);

	// Since 2 is the only number in the set, getRandom always return 2.
	randomSet.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
