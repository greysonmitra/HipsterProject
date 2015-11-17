package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
//  private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[5];
		setupArray();
//		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but,";
		hipsterPhrases[2] = "OMG Justin Bieber is so GREAT!!!!!!!!!!!!!!!!!!!!!!!";
		hipsterPhrases[3] = "I was into Owl City before they were cool...";
		hipsterPhrases[4] = "I actually listen to good music like Sir mixalot unlike people from my generation who listen to crap like Guy Fieri";
	}
	
	private void setupbooks()
	{
		
	}
	
	public Hipster(String name)
	{
		
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
}
