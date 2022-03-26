import java.util.*;


public class CardDeck {
	
	private Card[] theCards; // vektor med kort...
	private int removeCount;
	
	/** Skapar en kortlek */
	public CardDeck() {
		theCards = new Card[52]; //skapa vektorn
		removeCount = 0;
		
		// skapa korten
		int count = 0;
		for (int i = 1; i<14; i++) {
			for (int r = Card.SPADES; r<=Card.CLUBS; r ++) {
				Card c = new Card(r,i);
				theCards[count] = c;
				count += 1;
			}
		}	
	}
	
	/** Blandar kortleken */
	void shuffle() {
		Random r = new Random();
		
		//Reset removeCount only when shuffling the cards
		//If you would reset it in getCard or moreCards the methods would be working rather awkward
		//See the while-loop and the if statement right after in TestPatiens 
		removeCount = 0; 
		
		for (int i = 51; i>0; i--) {

			int nr = r.nextInt(i);
			
			Card currentCard = theCards[i];
			Card randomCard = theCards[nr];
			
			theCards[i] = randomCard;
			theCards[nr] = currentCard;
		}
	}
	
	/** Undersöker om det finns fler kort i kortleken */
	boolean moreCards() {
		return (removeCount < theCards.length);
	}
	
	/** Drar det översta kortet i leken */
	public Card getCard() {
		Card upperCard;
		
		if (removeCount < theCards.length) {
			upperCard = theCards[removeCount];
		} else {
			upperCard = null;
		}
		removeCount += 1;
		
		return upperCard;
	}
}
