

import java.util.*;


class Solution {

    public List<String> findItinerary(String[][] tickets) {
	for(int i=0; i<tickets.length; i++){
	    for(int j=0; j<tickets[0].length; j++){
	        System.out.print(tickets[i][j] + "  ");
	    }
	    System.out.println();
	}

        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK");

	System.out.println("route = " + route + "\n");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<String, PriorityQueue<String>>();
    
    List<String> route = new LinkedList<>();

    void visit(String airport) {
	System.out.println("visit(" + airport +")");
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
	
    }

    public static void main(String args[]){
	
	Solution s1 = new Solution();

	String[][] tickets = new String[][]{{"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}};
	s1.findItinerary(tickets);

	tickets = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
	s1.findItinerary(tickets);



    }
    
    
}
