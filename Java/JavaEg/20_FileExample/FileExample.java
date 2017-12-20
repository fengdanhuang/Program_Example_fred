import java.io.*;

	class FileExample
	{
		String sBasePath;
		long lBasePathSize;
		
		FileExample (String s)
		{
			sBasePath = s;
			lBasePathSize = 0;
		}
		
		void WalkTree ()
		{
			File f;
			f = new File (sBasePath);
			processNode (f);
			System.out.println ("\n	    Dir Node " + sBasePath + " represents " + lBasePathSize + " bytes\n");
		}
		
		void processNode (File fIn)
		{
			File f;
			String[] as;
			int i;
			
			if (fIn.isDirectory ())			//if it is a directory....
			{
				as = fIn.list ();			//..Get its file names
				
				for (i = 0; i < as.length; i++)
				{									//....For every file name
					f = new File (fIn, as[i]);		//....Create a file ohject
					processNode (f);				//........and process it.
				}
				
				System.out.println ("      Finished Dir: " + fIn.getPath ());
				return;//return在此表示跳出此函数！！！
			}
			
			lBasePathSize += fIn.length ();
			System.out.println (fIn.getPath ());
		}
		
		public static void main (String[] args)
		{
			FileExample x;
			
			if (args.length < 1)
			{
				System.out.println ("Format: java FileExample BasePath");
				System.exit (1);//exit(0)代表正常退出，exit(其他）代表错误退出；由此退出程序
			}
			
			x = new FileExample (args[0]);
			x.WalkTree();
		}
	}
	
	