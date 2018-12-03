package chat.view;

import javax.swing.*;
import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	
	public ChatPanel(ChatController appController)
	{
		super();
		
	}
}
