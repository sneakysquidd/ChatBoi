package chat.controller;

import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class IOController
{
	public static String loadFile(ChatController app, String path)
	{
		String contents = "";
		
		try
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if(saveFile.exists()) 
			{
				fileScanner = new Scanner(saveFile);
				while (fileScanner.hasNext()) 
				{
					contents += fileScanner.nextLine() + "\n";
				}
			}
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		return contents;
	}
		
	
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try
		{
			String filename = path;
			Calendar date = Calendar.getInstance();
			
			//Adds the calendar day, month, hour, and minute to the file path name
			filename += "/" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH);
			filename += "-";
			filename += date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE); 
			filename += " chatbot save.txt";
					
			//These use the file name declared above to save all the things in the chat area to a file
			File saveFile = new File(filename);
			Scanner textScanner = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
			
			textScanner.close();
			saveText.close();
		} 
		
		//These catch blocks send the error to handleErrors() method to process them
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
	}
}
