/**
 * Write your solution in this file.
 *
 * You can build, execute, and test your answer by either pressing 'Try Answer' in the side panel,
 * or by running the following commands on the command line:
 *
 * To build your answer:
 *            gradle build
 * To run the previously built executable:
 *            gradle run -q -P "appArgs='<test_case_path>'"
 * For example:
 *            gradle run -q -P "appArgs='inputs/large.json'"
 *
 * You can organize your code as you wish (eg, use auxiliary files) as long as `TestAnswer`
 * produces the expected output.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

class logfile
{
    public String ip;
    public int id;
    public double time;
    public logfile(String ip,double time,int id)
    {
        this.id = id;
        this.ip=ip;
        this.time=time;
    }
} 

public class Answer {

    /**
     * Implement your solution here.
     *
     * @param log_path String with path of Nginx access logfile.
     * @return A list of integers, representing the IDs of the rejected requests.
     */
    
    
    public static int[] rate_limit_traffic(String log_path) {
        BufferedReader br = null;
		FileReader fr = null;
        HashMap<String,Queue<logfile>> data = new HashMap<>();
        List<Integer> res = new ArrayList<>(); 
        try 
        {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(log_path);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) 
            { 
                String[] split = line.split(" ");
                String ip = split[1];
                int id = Integer.parseInt(split[0]);
                double time = Double.valueOf(split[2]);
                System.out.println("id = " + id + ",   time = " + String.valueOf(time));
                //String[] request = split[split.length-4].split("/");
                //int request = line.indexOf("\"");
                String request = line.substring(line.indexOf("\"")+5, line.indexOf("\"")+20);
                System.out.println("request = " + request);
                /*
                for(int i=0; i<request.length; i++)
                    System.out.println("request[0] = " + request[0]);
                */
                if(ip.equals("123.221.14.56"))
                    continue;
                if(!data.containsKey(ip))
                {
                    
                    Queue<logfile> queue = new LinkedList<>();
                    queue.add(new logfile(ip,time,id));
                    data.put(ip,queue);
                }
                else
                {
                    Queue<logfile> queue = data.get(ip);
                    while(!queue.isEmpty() && (time-queue.peek().time>1))
                        queue.poll();
                    while(queue.size()>9)
                    {
                        System.out.println("      id = " + id);
                        System.out.println("      queue.size() = " + queue.size());
                        res.add(queue.poll().id);
                    }
                    queue.add(new logfile(ip,time,id));
                }
                
                
			}

		} 
        catch (IOException e) 
        {

			e.printStackTrace();

		}
        System.out.println("res = " + res);
        return converter(res);
    }
    
    public static int[] converter(List<Integer> list)
    {
        int[] arr = new int[list.size()];
        for(int i = 0;i<list.size();i++)
        {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public static void main(String args[]){
        //String log_path = "/home/candidate/author_files/tests/try_answer/inputs/small.log";
        String log_path = "large.log";
        rate_limit_traffic(log_path);
    }
}
