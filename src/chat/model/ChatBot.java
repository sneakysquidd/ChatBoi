package chat.model;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Chatbot
{

	/**
	 * Getters
	 */

	
	public ArrayList<String> getSpookyList()
	{
		return SpookyList;
	}
	
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public String getCurrentUser()
	{
		return currentUser;
	}
	/**
	 * Setters
	 */

	// private constructors
	private ArrayList <String> responseList;
	{

	}

	private ArrayList <String> SpookyList;
	{

	}

	private String content;
	private String currentUser;
	private String joke;
	
	public Chatbot()
	{
		this.joke = "";
		this.content = new String("");
		this.currentUser = new String("");
		
		this.responseList = new ArrayList<String>();
		this.SpookyList = new ArrayList<String>();
		
		buildTheLists();
	}
	
	private void buildTheLists()
	{
		//response list
		responseList.add("How's it going! Hello!");
		responseList.add("All minions are immortal. Don't believe me? watch the minion movie");
		responseList.add("Nice");
		responseList.add("Epic. Banana");
		responseList.add("Adios mi amigo");
		responseList.add("Goodbye sir");
		responseList.add("?");
		responseList.add("Thats what I heard");
		responseList.add("that is funny");
		responseList.add("Have you tried googling it?");
		responseList.add("If you say so");
		responseList.add("Really?");
		responseList.add("Who?");
		responseList.add("Why?");
		responseList.add("uWu");
		responseList.add("xd lol");
		
		//spooky doo
		SpookyList.add("ya like minions? or Halloween?"); 
		SpookyList.add("SpOoKy");
		SpookyList.add("You shall be followed by a skelington");
		SpookyList.add("It's over for you");
		SpookyList.add("Pumpkin Smashing");
		SpookyList.add("Trick or Treat");
		SpookyList.add("Pumpkin carving");
		SpookyList.add("Yaga yote");
		SpookyList.add("Halloween");
	}
	
	public Boolean legitimacyChecker(String userText)
	{
		boolean isValid = true;
		
		if(userText == null || userText =="")
		{
			isValid = false;
		}
		else if (userText.length() < 1) 
		{
			isValid = false;
		}
		else if (userText.contains("sdf") || userText.contains("jkl") || userText.contains("cvb") || userText == "asdfghjkl")
		{
			isValid = false;
		}
			return isValid;
	}
	
	public Boolean contentChecker(String userText)
	{
		boolean isContent = true;
		
		return isContent;
	}
	public Boolean spookyChecker(String userText)
	{
		boolean isSpooky = true;
		
		
		for(String Phrase : SpookyList)
		{
			if (userText.contains(Phrase))
			{
				isSpooky = true;
			}
		}
		
		if (userText.contains("Halloween"))
		{
			isSpooky = true;
		}
		else if (userText.contains("Easter"))
		{
			isSpooky = false;
		}
		
		return isSpooky;
	}
	
	
	public String processText(String userText)
	{
		String answer = "";
		
		if (!legitimacyChecker(userText))
		{
			answer += "You really should not send null\n";
		}
		else
		{
			answer += "You said the special words.\n";
			
			if (contentChecker(userText))
			{
				answer += "You said: " + userText + "\n";
			}
			int randomIndex = (int) (responseList.size() * Math.random());
			answer += "Chatbot says: " + responseList.get(randomIndex) + "\n";
		}
		return answer;
	}

	public Chatbot(String string)
	{
		content = "sample content";
	}


}
