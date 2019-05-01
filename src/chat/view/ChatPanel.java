package chat.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import chat.controller.ChatController;
import chat.controller.IOController;

public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton resetButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JPanel buttonPanel;
	
	
	private ImageIcon chatIcon;
	private ImageIcon checkerIcon;
	private ImageIcon loadIcon;
	private ImageIcon saveIcon;
	private ImageIcon resetIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchIcon;
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		/**
		 * This Block of code initializes the data members with parameters
		 */
		chatIcon = new ImageIcon(getClass().getResource("/chat/view/images/beter.jpg"));
		checkerIcon = new ImageIcon(getClass().getResource("/chat/view/images/floofer.jpg"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/view/images/GavinKong.jpeg"));
		saveIcon = new ImageIcon(getClass().getResource("/chat/view/images/homework.jpg"));
		resetIcon = new ImageIcon(getClass().getResource("/chat/view/images/minion.JPG"));
		tweetIcon = new ImageIcon(getClass().getResource("/chat/view/images/perfect.jpg"));
		searchIcon = new ImageIcon(getClass().getResource("/chat/view/images/zucc_juice.jpg"));
		
		saveButton = new JButton("Save", saveIcon);
		loadButton = new JButton("Load", loadIcon);
		chatButton = new JButton("Chat", chatIcon);
		checkerButton = new JButton("Check Text", checkerIcon);
		resetButton = new JButton("Reset", resetIcon);
		tweetButton = new JButton("Send Tweet", tweetIcon);
		searchTwitterButton = new JButton("Search Twitter", searchIcon);
		
		
		chatField = new JTextField("Talk to the bot here", 50);
		
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		
		
		
		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 87, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, chatPane);
		

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
		setupButtonPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(new Color(47, 183, 111));
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		this.add(chatPane);
		this.add(chatField);
		buttonPanel.setPreferredSize(new Dimension(900,150));
		buttonPanel.setBackground(Color.GRAY);
		this.add(buttonPanel);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION);
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		
		return path;
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);

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
						
						
						chatArea.setCaretPosition(chatArea.getDocument().getLength());
					}
				});		
		
		loadButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String path = getPath("load");
						String chatText = IOController.loadFile(appController, path);
						chatArea.setText(chatText);
					}
				});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String chatText = chatArea.getText();
				String path = getPath("save");
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
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
				chatArea.setText("");
				chatField.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent tweetClick)
			{
				String textToTweet = chatField.getText().trim();
				appController.tweet(textToTweet);
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent searchClick)
			{
				String username = chatField.getText().trim();
				String display = appController.findWords(username);
				chatArea.append("\n\n" + display);
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
	
	private void setupButtonPanel()
	{
		buttonPanel.add(saveButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
	}
}
