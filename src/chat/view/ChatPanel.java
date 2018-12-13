package chat.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
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
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 18, SpringLayout.SOUTH, loadButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -107, SpringLayout.SOUTH, this);
		chatButton = new JButton("Chat");
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -142, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -50, SpringLayout.EAST, this);
		checkerButton = new JButton("Check Text");
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, checkerButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 399, SpringLayout.WEST, this);
		resetButton = new JButton("Reset");
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -21, SpringLayout.NORTH, resetButton);
		appLayout.putConstraint(SpringLayout.SOUTH, resetButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, resetButton, -39, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, resetButton, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, resetButton, -50, SpringLayout.EAST, this);
		chatField = new JTextField("Talk to the bot here", 50);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatPane);

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
		=
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
