package chat.controller;
import javax.swing.JOptionPane;

import chat.model.ChatBot;


public class ChatController
{
	private ChatBot simpleBot;

	public void Controller()
	{
		simpleBot = new ChatBot();
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
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Hi");
		text = userResponse;
		if (text == null)
		{
		 	JOptionPane.showMessageDialog(null, "You can't input a null value");
		 	text = "null";
		}

		
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
