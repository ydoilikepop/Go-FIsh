import java.util.ArrayList; 

public class Hand {
	
	// Not sure if I can start with 5 and dynamically increase the size
	// of the array. 
	ArrayList<Card> hand = new ArrayList<Card>(); 
	int points = 0; 
	
	// Draws a card from the deck and returns the deck with the top card removed.
	public Deck drawCard(Deck deck) {
		Card card = deck.getCard(deck.cardArr.size() - 1); 
		
		checkDouble(card); 
		Deck newDeck = deck; 
		deck.cardArr.remove(deck.cardArr.size() - 1);
		return deck; 
	}
	
	// If the guess from opponent matches any of the cards in hand then 
	//the method will return true. Otherwise it will return false. 
	public boolean guessCard(Card guess) {
		boolean correct = false;  
		int i = 0;
		do {
			if (guess.value == hand.get(i).value) {
				hand.remove(i); 
				correct = true; 
			}
			i++;
		} while (i < hand.size()); 
		
		return correct; 
	}
	
	// Checks to see if a card in hand has the same value as card. If it does,
	// add 1 to points and remove that card from hand. Otherwise, add the
	// new card to hand. 
	public void checkDouble(Card card) {
		for (int i = 0; i < hand.size(); i++) {
			if (card.value == hand.get(i).value) {
				hand.remove(i); 
				points++;
			} else {
				hand.add(card); 
			}
		}
	}
}