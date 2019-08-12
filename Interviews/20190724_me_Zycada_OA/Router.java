import java.util.*;
import java.io.*;

//Define a trie node class
class TrieNode{
    boolean isWord = false;
    TrieNode[] children = new TrieNode[256];
}

//Router class: implement all functionalities
public class Router{

    public Map<String,String> map0Star = new HashMap<>(); //Used to store all domain name with no '*' and corresponding server
    public Map<String,String> map1Star = new HashMap<>(); //Used to store all domain name with one '*' and corresponding server name
    public Map<String,String> map2Star = new HashMap<>(); //Used to store all domain name with two '*' and corresponding server name
    public Map<String,String> map3Star = new HashMap<>(); //Used to store all domain name with three '*' and corresponding server name
    public String allStarServer; //Used to store the server name when there is four '*'
    public TrieNode root; //the root of the TrieNode
    
    public Router(){
        map0Star = new HashMap<>();
        map1Star = new HashMap<>();
        map2Star = new HashMap<>();
        map3Star = new HashMap<>();
        root = new TrieNode();   
    }
    
    //Insert a word(a name from domain name) into the trie
    public void insert(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            //System.out.println(c);
	    if(cur.children[c] == null) cur.children[c] = new TrieNode();
	    cur = cur.children[c];
        }
        cur.isWord = true;
    }
    //Search a word to check if this word is in the trie; If there is not, return false
    public boolean search(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c] == null) return false;
            cur = cur.children[c];
        }
        return cur.isWord;
    }
    // Read input file from command line
    public List<String> readFile(String dir) throws IOException{
        List<String> input = new ArrayList<>();
        File file = new File(dir); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String st; 
        System.out.println("\nThe config file is:\n");
        while ((st = br.readLine()) != null){ 
            System.out.println(st); 
            input.add(st);
        }
        System.out.println("----------------------------");
        return input;
    }

    //In this method: first read the config info from config file. Then store all domain from domain name into the trie, used
    //for search usage. Also store the domain name and server name into the hash Maps.
    public void loadConfig(String dir){
        try{
            List<String> input = readFile(dir);
            if(input == null) throw new IOException("There is no input!");
            for(String line : input){
                String[] li = line.split("=");
                String[] dom = li[0].split("\\.");
                if(!dom[0].equals("*") && !dom[1].equals("*") && !dom[2].equals("*") && !dom[3].equals("*")){
                      insert(dom[0]); insert(dom[1]); insert(dom[2]); insert(dom[3]);
                      map0Star.put(li[0], li[1]);
                }else if(!dom[0].equals("*") && !dom[1].equals("*") && !dom[2].equals("*") && dom[3].equals("*")){
                      insert(dom[0]); insert(dom[1]); insert(dom[2]);
                      map1Star.put(dom[0]+"."+dom[1]+"."+dom[2], li[1]);
                }else if(!dom[0].equals("*") && !dom[1].equals("*") && dom[2].equals("*") && dom[3].equals("*")){
                      insert(dom[0]); insert(dom[1]); 
                      map2Star.put(dom[0]+"."+dom[1], li[1]);
                }else if(!dom[0].equals("*") && dom[1].equals("*") && dom[2].equals("*") && dom[3].equals("*")){
                      insert(dom[0]);
                      map3Star.put(dom[0], li[1]);
                }else if(dom[0].equals("*") && dom[1].equals("*") && dom[2].equals("*") && dom[3].equals("*")){
                      allStarServer = li[1];
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Given a domain name. Search it from both the trie and hash map so that it can find the corresponding server name.
    public String findRoute(String domNames){
        String[] dom = domNames.split("\\.");
        if(search(dom[0]) && search(dom[1]) && search(dom[2]) && search(dom[3])){
            return map0Star.get(domNames);
        }else if(search(dom[0]) && search(dom[1]) && search(dom[2]) && !search(dom[3])){
            return map1Star.get(dom[0] + "." + dom[1] + "." + dom[2]);
        }else if(search(dom[0]) && search(dom[1]) && !search(dom[2]) && !search(dom[3])){
            return map2Star.get(dom[0] + "." + dom[1]);
        }else if(search(dom[0]) && !search(dom[1]) && !search(dom[2]) && !search(dom[3])){
            return map3Star.get(dom[0]);
        }else{
            return allStarServer;
        }
    }

    public static void main(String[] args) throws Exception{
        if (args == null || args.length == 0){
            System.out.println("There is no input file.");
            System.exit(0);
        }
        String dir = args[0];
        System.out.println("\nThe directory and file is: " + dir);
        Router ro = new Router();
        ro.loadConfig(dir);

        System.out.println("findRoute(\"customer1.us.ca.sfo\"):");
        System.out.println("    " + ro.findRoute("customer1.us.ca.sfo"));
        System.out.println("findRoute(\"customer1.us.ca.sjc\"):");
        System.out.println("    " + ro.findRoute("customer1.us.ca.sjc"));
        System.out.println("findRoute(\"customer2.us.tx.dfw\"):"); 
        System.out.println("    " + ro.findRoute("customer2.us.tx.dfw")); 
        System.out.println("findRoute(\"customer2.cn.tw.tai\"):");
        System.out.println("    " + ro.findRoute("customer2.cn.tw.tai"));
        System.out.println("findRoute(\"customer10.us.ny.nyc\"):"); 
        System.out.println("    " + ro.findRoute("customer10.us.ny.nyc")); 
    }
}

