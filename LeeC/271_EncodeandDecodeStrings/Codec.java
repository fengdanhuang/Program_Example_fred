
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Codec {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        System.out.println("strs = " + strs);
	StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
	String res = sb.toString();
	System.out.println("res = " + res);
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }


    public static void main(String args[]){

	List<String> strs= new ArrayList<String>(Arrays.asList("ab", "cde"));
	Codec codec = new Codec();
	codec.decode(codec.encode(strs));

    }
}
