package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController appController)
	{
		super();
		
		this.appController = appController;
		this.appPanel = new ChatPanel(appController);
	
		setupFrame();
	}
	
	private void setupFrame()
	{
		int fortnite = 1024;
		
		this.setContentPane(appPanel);
		this.setSize(fortnite, 768);
		this.setTitle("hmmmmm");
		this.setResizable(true);
		this.setVisible(true);
	}
}
