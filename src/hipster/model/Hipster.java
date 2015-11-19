package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[5];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but,";
		hipsterPhrases[2] = "OMG Justin Bieber is so GREAT!!!!!!!!!!!!!!!!!!!!!!!";
		hipsterPhrases[3] = "I was into Owl City before they were cool...";
		hipsterPhrases[4] = "I actually listen to good music like Sir mixalot unlike people from my generation who listen to crap like Guy Fieri";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		firstBook = new Book();
		firstBook.setAuthor("Neal Stephenson");
		firstBook.setTitle("Diamonds in the rough");
		firstBook.setSubject("Autobiography");
		firstBook.setPageCount(6000);
		firstBook.setPrice(89.99);
		
		secondBook = new Book(361, "Rick Riordan", "The Last Olympian", "Fantasy", 19.99);
		
		
		thirdBook = new Book();
		thirdBook.setAuthor("Shaun Weasley");
		thirdBook.setTitle("Mastering the 'Magic' of Sandbagging");
		thirdBook.setSubject("Documentary");
		thirdBook.setPageCount(34696);
		thirdBook.setPrice(120);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}
	
	public Hipster(String name)
	{
		this.name = name;
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
