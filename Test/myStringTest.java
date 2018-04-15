
import java.util.regex.Pattern;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import org.apache.spark.sql.DataFrame;

public class myStringTest {

	public static void main(String[] args) {
		
		String centroidsStr = "[[1.17, 2.48e-14], [19.48, 55.35]]";
		final String centroidDelimiter = "], [";
		
		String[] centroidsArr = centroidsStr.substring(2, centroidsStr.length() - 2).split(Pattern.quote(centroidDelimiter));
		
		System.out.println("centroidsArr  = " + centroidsArr);
		
		for (int i=0; i<centroidsArr.length; i++){
			System.out.println("centroidsArr[i] = " + centroidsArr[i]);
		}
		
//		Date scoredate = new DateTime(new Date(Long.parseLong(lastRecScore.getRecordID()))).minusDays(1).toDate();
//		String scoreDateStr = df.format(scoredate);
		
		String a = null;
		a = "";
		System.out.println(a.length());

	}

}
