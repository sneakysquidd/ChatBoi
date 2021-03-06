package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.

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
		
		saveButton = new JButton("Save");

		
		loadButton = new JButton("Load");
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, saveButton);

		chatButton = new JButton("Chat");
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 4, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -108, SpringLayout.SOUTH, this);
		
		resetButton = new JButton("Reset");
		appLayout.putConstraint(SpringLayout.NORTH, resetButton, 6, SpringLayout.SOUTH, loadButton);

		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});


		checkerButton = new JButton("Check Text");


		
		
		
		chatField = new JTextField("Talk to the bot here", 50);


		chatField.setHorizontalAlignment(SwingConstants.CENTER);
		

		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, resetButton, 0, SpringLayout.EAST, chatPane);


		chatArea = new JTextArea("", 20, 50);
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();	
		
	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 6, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -160, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, -351, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -4, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -6, SpringLayout.WEST, checkerButton);
		
		
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
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				IOController.saveText(appController, output, input);
				chatField.setText("Chat saved!");
			}
		});
		
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText("");
				chatField.setText("");
			}
		});
		
	}
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.GRAY);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(checkerButton);
		this.add(loadButton);
		this.add(chatField);
		this.add(resetButton);
		
	}
}