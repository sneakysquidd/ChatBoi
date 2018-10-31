package chat.model;
import java.util.ArrayList;

public class ChatBot
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
		return ResponseList;
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
	private ArrayList <String> ResponseList;
	{

	}

	private ArrayList <String> SpookyList;
	{

	}

	private String content;
	private String currentUser;
	private String joke;
	
	public ChatBot()
	{
		this.joke = "";
		this.content = new String("");
		this.currentUser = new String("");
		
		this.ResponseList = new ArrayList<String>();
		this.SpookyList = new ArrayList<String>();
		
		buildTheLists();
	}
	
	private void buildTheLists()
	{
		//response list
		ResponseList.add("How's it going! Hello!");
		ResponseList.add("All minions are immortal. Don't believe me? watch the minion movie");
		ResponseList.add("Nice");
		ResponseList.add("Epic. Banana");
		ResponseList.add("Adios mi amigo");
		ResponseList.add("Goodbye sir");
		ResponseList.add("?");
		ResponseList.add("Thats what I heard");
		ResponseList.add("that is funny");
		ResponseList.add("Have you tried googling it?");
		ResponseList.add("If you say so");
		ResponseList.add("Really?");
		ResponseList.add("Who?");
		ResponseList.add("Why?");
		ResponseList.add("uWu");
		ResponseList.add("xd lol");
		
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
		
		if(userText == null)
		{
			isValid = false;
		}
		else if (userText == "")
		{
			isValid = false;
		}
		else if (userText.length() > 1) 
		{
			isValid = true;
		}
		else if (userText.contains("sdf") || userText.contains("jkl") || userText.contains("cvb"))
		{
			isValid = false;
		}
		else if (userText == "asdfghjkl" )
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
		
		
		for(String phrase : SpookyList)
		{
			if (userText.contains(phrase))
			{
				isSpooky = true;
			}
			else
			{
				isSpooky = false;
			}
			
		}
		
		if (userText.contains("Halloween"))
		{
			isSpooky = true;
		}
		/**
		if(userText == null)
		{
			isSpooky = false;
		}
		else if (userText.contains("Halloween"))
		{
			isSpooky = true;
		}
		else if (SpookyList.contains("Halloween"))
		{
			isSpooky = true;
		}
		else if (userText.contains("Easter"))
		{
			isSpooky = false;
		}
		**/
		return isSpooky;
		
	}
	
	
	public String processText(String userText)
	{
		userText += "You said: " + userText;
		userText += "Chatbot says: " + userText;
		
		return userText;
	}

	public ChatBot(String string)
	{
		content = "sample content";
	}


}
