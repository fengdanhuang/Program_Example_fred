

import java.util.*;


public class Logger {
    
    HashMap<String,Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        map=new HashMap<>();
	System.out.println("map = " + map);
    }


    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.      The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        System.out.println("timestapm = " + timestamp);
	System.out.println("message = " + message);
	//update timestamp of the message if the message is coming in for the first time,or the last coming time is earlier than 10 seconds from now
        if(!map.containsKey(message)||timestamp-map.get(message)>=10){
            map.put(message,timestamp);
	    System.out.println("    map = " + map);
            System.out.println("    true!");
            return true;
        }
	System.out.println("map = " + map);
        System.out.println("false!");
        return false;
    }

    public static void main(String args[]){
	Logger logger = new Logger();
  	logger.shouldPrintMessage(1, "foo");
	logger.shouldPrintMessage(2,"bar");
	logger.shouldPrintMessage(3,"foo");
	logger.shouldPrintMessage(8,"bar");
	logger.shouldPrintMessage(10,"foo");
	logger.shouldPrintMessage(11,"foo");
    }
}
