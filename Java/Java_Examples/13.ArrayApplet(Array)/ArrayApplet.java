import java.applet.*;
import java.awt.*;


	public class ArrayApplet extends Applet
/*******************************************************************************

	ArrayApplet -- Displays Strings in all the System Fonts
	
*******************************************************************************/


	{
	
	final int[] aiStyle = /* Font Style codes.*/ //final表示常量，相当于C中的#define和C++的Const
	{
	Font.PLAIN,
	Font.BOLD,
	Font.ITALIC,
	Font.ITALIC | Font.BOLD
	};
	
	final String[] asStyle = /*Desc of each Font Style*/
	{
	"Plain",
	"Bold",
	"Italic",
	"Italic Bold"
	};
	
	int iFontSize; // Point Size of the font.
	
	/********************************************************************************/
	
	public String getAppletInfo ()
	{
	return ("ArrayApplet v1.0, (c) Noel Enete,1996");
	}
	
	public void init ()
	{
	Color cForeground;
	Color cBackground;
	String sFontSize;
	
	cBackground = stringToColor
	(getParameter ("BackgroundColor"),
	 Color.lightGray
	 );
	
	cForeground = stringToColor
	(
	getParameter ("ForegroundColor"),
	Color.black
	);
	
	setBackground (cBackground);
	setForeground (cForeground);
	
	sFontSize = getParameter ("FontSize");
	if (sFontSize == null)
	{
	sFontSize = "22";
	}
	
	iFontSize = Integer.valueOf (sFontSize).intValue ();
	
	}
	
	public Color stringToColor (String sColor, Color cDefault)
	{
	Integer iRgb;
	
	if ((sColor == null)|| (sColor.charAt (0) != '#')
	|| (sColor.length () != 7))
	{
	return (cDefault);
	}
	
	try
	{
	iRgb = Integer.valueOf (sColor.substring(1,7), 16);
	return (new Color (iRgb.intValue ()));
	}
	catch (Exception e)
	{
	return (cDefault);
	}
	}
	
	public void paint (Graphics g)
	{
	Font fFont;		//selected font
	int i,j;	//Counters
	int x,y;	//Point at which to write string
	String[] asFontName; //Array of font face name
	FontMetrics fm;	//Metrics of Current font.
	
	asFontName = Toolkit.getDefaultToolkit ().getFontList ();
	
	x=5;
	y=0;
	
	for (i = 0; i < asFontName.length; i++)
	{
		for (j = 0; j <aiStyle.length; j++)
		{
		fFont = new Font
		(
		asFontName [i],
		aiStyle[j],		
		iFontSize
		);
		g.setFont (fFont);
		fm = g.getFontMetrics ();
		y += fm.getHeight ();
		
		g.drawString (asFontName[i] + asStyle[j] + ", "
		 + iFontSize + "pt", x, y);
		}
	}
	}
	
	}
	
	
	