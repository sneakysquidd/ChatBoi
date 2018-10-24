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
		return null;
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
		ResponseList.add("How's it going!");
		ResponseList.add("Thats pretty cool");
		ResponseList.add("Nice");
		ResponseList.add("Cool beans bro");
		ResponseList.add("Adios mi amigo");
		ResponseList.add("Who died?");
		
		//spooky doo
		SpookyList.add("ya like minions?");
		SpookyList.add("SpOoKy");
		SpookyList.add("You shall be followed by a skelington");
		SpookyList.add("It's over for you");
		SpookyList.add("Pumpkin Smashing");
	}
	
	public Boolean legitimacyChecker(String userText)
	{
		boolean isValid = true;
		
		if(userText == null)
		{
			isValid = false;
		}
		else if (userText.length() < 2) 
		{
			isValid = false;
		}
		else if (userText.contains("sdf") || userText.contains("jkl") || userText.contains("cvb"))
		{
			
		}
			return isValid;
	}
	
	
	public String processText(String userText)
	{
		String answer = "";
		
		answer += "you said: " + userText;
		
		return answer;
	}


}
