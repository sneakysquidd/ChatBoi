package chat.controller;
import javax.swing.JOptionPane;

import chat.model.ChatBot;


public class ChatController
{
	private ChatBot simpleBot;

	public  void Controller()
	{
		simpleBot = new ChatBot();
	}

	public void start()
	{
		//String UserInput = "";
		
			String userInput = "";
					
			while(!userInput.equalsIgnoreCase("quit"))
			{
				userInput = interactWithChatbot(userInput);
			}
	
	}

	
	public String interactWithChatbot(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Hi");
		output = simpleBot.processText(userResponse);
		
		return output;
	}
	
	public String useChatbotCheckers(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Wazzzzzup");
		
		return output;
	}
	
	public ChatBot getChatbot()
	{
		return simpleBot;
	}
}
