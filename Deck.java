import java.util.ArrayList; 

public class Deck {
	
	// Member variables 
	ArrayList<Card> cardArr = new ArrayList<Card>();
	
	public Deck() {
		initDeck(); 
		shuffleDeck(); 
	}
	
	// Initializes the deck so we have one of each card. 
	private void initDeck() {
		char[] suit = {'S', 'H', 'C', 'D'};
		
		for (int s : suit) {
			for (int v = 1; v <= 13; v++) { 
					Card newCard = new Card(v, suit[s]);
					cardArr.add(newCard);
			}
		}
	}
	
	public Card randomCard() {
		int s = (int)(Math.random() * 4 + 1); 
		char suit = 'S'; 
		
		switch (s) {
			case 1 : suit = 'S';
				break; 
			case 2 : suit = 'D'; 
				break; 
			case 3 : suit = 'C'; 
				break; 
			case 4 : suit = 'H';
				break;
			default : System.out.println("Something went wrong."); 
		}
			
		Card card = new Card((int)(Math.random() * 13 + 1), suit); 
		return card; 
	}
	
	
	// Randomizes the order of the deck. 
	private void shuffleDeck() {
		ArrayList<Card> shuffled = new ArrayList<Card>(); 
		int value;  
		
		// Probably really inefficient way to shuffle. 
		for (int i = 0; i < 52; i++) {	
			do {
				value = (int)(Math.random() * 52 + 1);
				if (this.cardArr.get(value).value != -1) {
					shuffled.add(cardArr.get(i));
				}
			} while (this.cardArr.get(value).value == -1);
			
			this.cardArr.get(value).value = -1; 
		}
		
		cardArr.clear();
		cardArr.addAll(shuffled); 
	}
	
	public Card getCard(int index) {
		return cardArr.get(index);
	}
}