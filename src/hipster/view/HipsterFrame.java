package hipster.view;

import javax.swing.JFrame;
// import gui.controller.GUIController;
// import gui.view.GUIPanel;
import hipster.controller.HipsterController;
import javax.swing.*;

public class HipsterFrame extends JFrame
{
	private HipsterController hipController;
	private HipsterPanel hipPanel;
	
	public HipsterFrame(HipsterController hipController)
	{
		this.hipController = hipController;
		hipPanel = new HipsterPanel(hipController);
		setupFrame();
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setContentPane(hipPanel); 
		this.setSize(400,400); 			
		this.setTitle("HELLOOO");
		this.setResizable(false);       
		this.setVisible(true);		   
	} 
	
	public HipsterController getBaseController()
	{
		return hipController;
	}
}
