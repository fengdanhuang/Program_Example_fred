import java.applet.*;
import java.awt.*;


	public class ParmApplet extends Applet
/***************************************************************************

	ParmApplet	-- Java Applet that Demonstrates Passing Web Page Parameter
	
*******************************************************************/


	{
	
	int iFontSize;	/* Point size of the font.	*/
	String sMessage;/* Message to write to the screen.	*/
	
	public String getAppletInfo ()
	{
	return ("ParmApplet v1.0,	(c) Noel Enete, 1996");
	}
	
	
	public void init ()
	{
	Color cForeground;
	Color cBackground;
	String sFontSize;
	
	sMessage = getParameter ("Message");
	
	sFontSize = getParameter ("Font Size");
	
	if (sFontSize == null)
	{
	sFontSize = "22";
	}
	
	iFontSize = Integer.valueOf(sFontSize).intValue ();
	
	cBackground = stringToColor
	(
	getParameter ("BackgroundColor"),
	getBackground ()
	);
	
	cForeground = stringToColor
	(
	getParameter ("ForegroundColor"),
	Color.black
	);
	
	setBackground (cBackground);
	setForeground (cForeground);
	}

/*"#FF0000" Red
  "#00FF00" Green
  "#0000FF" Blue
  "#808080" Gray
  "#FFFFFF" White
  "#000000" Black
 */	
	public Color stringToColor (String sColor, Color cDefault)
	{
	Integer iRgb;
	
	if ((sColor == null)
	|| (sColor.charAt (0) != '#')
	|| (sColor.length () != 7))
		{
		return (cDefault);
		}
		
	try
	   {
	   iRgb = Integer.valueOf (sColor.substring (1,7), 16);
	   return (new Color (iRgb.intValue ()));
	   }
	catch (Exception e)
	   {
	   return (cDefault);
	   }
	}
	
	
	public void paint (Graphics g)
	{
	Font fFont;	/*selected font.*/
	int x,y;		//Point ar which to wrinte string.
	FontMetrics fm;
	
	fFont = new Font
	(
	"TimesRoman",
	Font.BOLD,
	iFontSize
	);
	
	g.setFont (fFont);
	fm = g.getFontMetrics ();
	
	x = 5;
	y = fm.getHeight ();
	g.drawString (sMessage, x, y);
	}
	
}



	