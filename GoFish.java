import java.util.Scanner;
public class GoFish {
	
	public static final int HAND_SIZE = 5; 
	
	public static void main(String[] args) {
	
		// Initialize a hand. 
		Hand player = new Hand(); 
		Hand cpu = new Hand(); 
		Deck deck = new Deck(); 
		boolean gameover = false; 
		Scanner playerInput = new Scanner(System.in); 
		
		// Start each player off with 5 cards. Any doubles they get while 
		// drawing will be counted as points and a new card will be drawn
		// until both players are at 5 cards. 
		do {
			player.drawCard(deck); 
			cpu.drawCard(deck); 
		} while (player.hand.size() < HAND_SIZE); 
		
		while (!gameover) {
			System.out.println("Guess cpu's card: "); 
			String guess = playerInput.next(); 
			
			Card cardGuess = new Card(Integer.parseInt(guess.substring(
			0, guess.length() - 1)), guess.charAt(guess.length() - 1)); 
			
			if (!cpu.guessCard(cardGuess)) {
				System.out.println("Go fish!"); 
				player.drawCard(deck); 
			} else {
				player.checkDouble(cardGuess); 
			}
			
			gameover = isGameover(player, cpu, deck); 
			
			System.out.println("Now it's cpu's turn.");
			
			Card cpuGuess = deck.randomCard(); 
			System.out.println("Cpu guesses: " + cpuGuess.value + cpuGuess.suit);
			
			if (player.guessCard(cpuGuess)) {
				System.out.println("Go fish!");
				cpu.drawCard(deck); 
			} else {
				cpu.checkDouble(cpuGuess); 
			}
			
			gameover = isGameover(player, cpu, deck);
		}
	}
	
	// Returns true if either players' hands are empty and the deck is emtpy. 
	public static boolean isGameover(Hand player, Hand cpu, Deck deck) {
		if (deck.cardArr.size() == 0 && (player.hand.size() == 0 ||
			cpu.hand.size() == 0)) {
			return true; 
		} else {
			return false; 
		}
	}
}