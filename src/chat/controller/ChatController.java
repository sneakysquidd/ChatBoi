package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatFrame;


public class ChatController
{
	private Chatbot simpleBot;
	private Frame appFrame;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new Frame(this);
	}

	public void start()
	{	
			String userInput = JOptionPane.showInputDialog("Howdy");
					
			while(!userInput.equalsIgnoreCase("quit"))
			{
				userInput = interactWithChatbot(userInput);
			}
	}

	
	public String interactWithChatbot(String text)
	{
		String isNull = "not null";
//		String output = "";
		String userResponse = JOptionPane.showInputDialog("Hi");
		text = userResponse;
		if (text == null)
		{
		 	JOptionPane.showMessageDialog(null, "You can't input a null value");
		 	isNull = "null";
		}
		return isNull;
	}
	
	public String useChatbotCheckers(String text)
	{
		
		String testedValues = "The following checkers passed successfully: ";
		if (simpleBot.contentChecker(text))
		{
			testedValues += "\nContent Checker";
		}
		if (simpleBot.spookyChecker(text))
		{
			testedValues += "\nSpooky Checker Happy Halloween";
		}
		if (simpleBot.legitimacyChecker(text))
		{
			testedValues += "\nLegitimacy Checker";
		}
		
		return testedValues;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}
