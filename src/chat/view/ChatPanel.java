package chat.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton resetButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		/**
		 * This Block of code initializes the data members with parameters
		 */
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");	
		checkerButton = new JButton("Check Text");
		resetButton = new JButton("Reset");
		chatField = new JTextField("Talk to the bot here", 50);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupPanel()
	{
		this.setBackground(new Color(47, 183, 111));
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(resetButton);
		this.add(chatField);
	}
	
	private void setupLayout()
	{
		//Chat Button
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 53, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -54, SpringLayout.EAST, this);
		
		//Load Button
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 114, SpringLayout.EAST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 50, SpringLayout.WEST, this);
		
		//Chat Pane
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		
		
		//Chat Field
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 53, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 53, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 53, SpringLayout.SOUTH, chatField);
		
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -74, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -119, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -74, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -74, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -74, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String input = chatField.getText();
						String output = "";
						output = appController.interactWithChatbot(input);
						chatArea.append(output);
						chatArea.setText("");
						chatField.setText("");
						chatArea.setCaretPosition(chatArea.getDocument().getLength());
					}
				});		
		
		
		loadButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						
					}
				});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setLineWrap(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
}
