package hipster.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import hipster.controller.HipsterController;
import hipster.model.Book;

public class HipsterPanel extends JPanel
{
	private HipsterController hipController;
	private JButton changeBookButton;
	private JTextField hipField;
	private SpringLayout hipLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookAuthorLabel;
	private JLabel bookPageCountLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController hipController)
	{
		this.hipController = hipController;
		hipLayout = new SpringLayout();
		bookAuthorLabel = new JLabel("The page count");
		bookPageCountLabel = new JLabel("The author");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		bookPriceLabel = new JLabel("The price");
		changeBookButton = new JButton("Change books");
		phraseComboBox = new JComboBox<String>();
		maxClicks = hipController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupComboBox()
	{
		String [] phrases = hipController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	
	private void setupPanel()
	{
		this.setLayout(hipLayout);
		this.setBackground(Color.cyan);
		this.add(phraseComboBox);
		this.add(changeBookButton);
		this.add(bookAuthorLabel);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
//		this.add(hipField);
	}
	
	
	private void setupLayout()
	{
		hipLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 35, SpringLayout.NORTH, this);
		hipLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 0, SpringLayout.WEST, this);
		hipLayout.putConstraint(SpringLayout.WEST, changeBookButton, 48, SpringLayout.WEST, this);
		hipLayout.putConstraint(SpringLayout.SOUTH, changeBookButton, -10, SpringLayout.SOUTH, this);
		hipLayout.putConstraint(SpringLayout.NORTH, bookPriceLabel, 55, SpringLayout.SOUTH, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.EAST, bookPriceLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -44, SpringLayout.NORTH, bookPageCountLabel);
		hipLayout.putConstraint(SpringLayout.EAST, bookTitleLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.SOUTH, bookPageCountLabel, -44, SpringLayout.NORTH, bookSubjectLabel);
		hipLayout.putConstraint(SpringLayout.SOUTH, bookSubjectLabel, -52, SpringLayout.NORTH, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.EAST, bookPageCountLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		hipLayout.putConstraint(SpringLayout.WEST, bookAuthorLabel, 223, SpringLayout.WEST, this);
		hipLayout.putConstraint(SpringLayout.SOUTH, bookAuthorLabel, -266, SpringLayout.SOUTH, this);
	}
	
	private void changeColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeColor();
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				hipController.getHipFrame().setTitle(updatedTitle);
			}
		});
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
				Book [] tempBooks = hipController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject: " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book page count: " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title: ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
			}
		});
	}
}
