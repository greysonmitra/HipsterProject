package hipster.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import hipster.controller.HipsterController;
//import hipster.model.book;

public class HipsterPanel extends JPanel
{
	private HipsterController hipController;
	private JButton hipButton;
	private JTextField hipField;
	private SpringLayout hipLayout;
	private JComboBox<String> phraseComboBox;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController hipController)
	{
		this.hipController = hipController;
		
		hipLayout = new SpringLayout();
		hipButton = new JButton("Tha button yo");
		hipField = new JTextField("words go here");
		phraseComboBox = new JComboBox<String>();
		
		
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
//		this.add(hipButton);
//		this.add(hipField);
	}
	
	
	private void setupLayout()
	{
		hipLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 62, SpringLayout.NORTH, this);
		hipLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 0, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				hipController.getHipFrame().setTitle(updatedTitle);
			}
		});
		
		hipButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				hipField.setText("Wow, you managed a click event! Wow!!!!!!!!");
			}
		});
	}
}
