package chat.controller;
import javax.swing.JOptionPane;

import chat.model.ChatBot;
import chat.model.ChatTwitter;
import chat.view.ChatFrame;


public class ChatController
{
	private ChatBot simpleBot;
	private ChatFrame appFrame;
	private ChatTwitter myTwitter;
	
	public ChatController()
	{
		simpleBot = new ChatBot();
		appFrame = new ChatFrame(this);
		myTwitter = new ChatTwitter(this);
	}

	public void start()
	{	

	}

	
	public String interactWithChatbot(String text)
	{
		String output = "";
		output += simpleBot.processText(text);
		return output;
	}
	
	public String useChatbotCheckers(String text)
	{
		
		String testedValues = "The following checkers passed successfully: ";
		if (simpleBot.contentChecker(text))
		{
			testedValues += "\nContent Checker";
		} 		if (simpleBot.spookyChecker(text))
		{
			testedValues += "\nSpooky Checker Happy Halloween";
		}
		if (simpleBot.legitimacyChecker(text))
		{
			testedValues += "\nLegitimacy Checker";
		}
		
		return testedValues;
	}
	
	private void close()
	{
		System.exit(0);
	}

	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
	
	public ChatFrame getAppFrame()
	{
		return appFrame;
	}
	
	public ChatBot getChatbot()
	{
		return simpleBot;
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String findWords(String user)
	{
		String results = myTwitter.getMostCommonWord(user);
		return results;
	}
}
