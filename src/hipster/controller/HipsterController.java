package hipster.controller;

import hipster.view.HipsterFrame;
import hipster.model.Hipster;

public class HipsterController
{

	private HipsterFrame hipFrame;
	private Hipster firstHipster;
	
	public HipsterController()
	{
		firstHipster = new Hipster();
		hipFrame = new HipsterFrame(this);
	}
	
	public void start()
	{
		String myName = hipFrame.getResponse("What is you name?");
		firstHipster.setName(myName);
		hipFrame.setTitle(myName + "'s Hipster Project!");
	}
	
	public Hipster getFirstHipster()
	{
		return firstHipster;
	}
	
	public HipsterFrame getHipFrame()
	{
		return hipFrame;
	}
}
