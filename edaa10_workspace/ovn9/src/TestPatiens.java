
public class TestPatiens {

	public static void main(String[] args) {
		
		CardDeck deck = new CardDeck();
		
		int patiensCount = 1;
		int wins = 0;
		int iterations = 100000;
		double probability;
		
		for (int i = 0; i<iterations; i++) { //x amount if game iterations
			patiensCount = 1;

			deck.shuffle(); //Shuffle card deck before playing game.
			
			int rank = deck.getCard().getRank();
			
			while (deck.moreCards() && rank != patiensCount) {
				rank = deck.getCard().getRank();
				
				if (patiensCount == 3) {
					patiensCount = 1;
				} else {
					patiensCount += 1;
				}
			}
			
			//If you would reset the removeCount in class CardDeck in the moreCards()-method, this would always be true, since removeCount < length of card deck
			if (!deck.moreCards()) { 
				wins += 1;
			}
		}
		
		probability = ((double) wins) / ((double) iterations);
		
		System.out.println("Sannolikheten är " + probability);
	}
}
