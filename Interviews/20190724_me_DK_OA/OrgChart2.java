import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}

class ConsoleProcessor {

    public OrgChart orgChart = new OrgChart();

    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
           numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }

    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }

        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

class OrgChart {
    class Employee{
        String id;
        String name;
        String managerId;
    }

    class Manager{
        String id;
        List<Employee> list;
    }

    Map<String, Employee> map;
    Map<String, Manager> map2;
    public OrgChart(){
        map = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void add(String id, String name, String managerId)
    {
        Employee em = new Employee();
        em.id = id;
        em.name = name;
        if(!map.containsKey(managerId)) em.managerId = "-1";
        else em.managerId = managerId;

        if(!map.containsKey(id)){
            /*
            Employee em = new Employee();
            em.id = id;
            em.name = name;
            if(!map.containsKey(managerId)) em.managerId = "-1";
            else em.managerId = managerId;*/
            map.put(id,em);
            
        }

        if(!map.containsKey(managerId)){
            Manager mm = new Manager();
            mm.id = managerId;
            mm.list = new ArrayList<>();
        }else{
            map2.get(managerId).list.add(em);
        }
        
        //throw new UnsupportedOperationException();
    }

    public void print()
    {
        for(String id : map.keySet()){
            //System.out.println(map.get(id).name + " [" + map.get(id).managerId + "]");
            System.out.println(map.get(id).name + " [" + id + "]");
        }
        //throw new UnsupportedOperationException();
    }

    public void remove(String employeeId)
    {
        if(map.containsKey(employeeId)){
            map.remove(employeeId);
        }
        //throw new UnsupportedOperationException();
    }

    public void move(String employeeId, String newManagerId)
    {
        if(map.containsKey(employeeId)){
            if(map.containsKey(newManagerId)){
                Employee em = map.get(employeeId);
                em.managerId = newManagerId;
                map.put(employeeId, em);
            }
        }
        //throw new UnsupportedOperationException();
    }

    public int count(String employeeId)
    {
        //return map.size();
        int cnt = 0;
        for(String id : map.keySet()){
            if(map.get(id).managerId == employeeId){
                cnt++;
            }
        }
        return cnt;
        //throw new UnsupportedOperationException();
    }
}

