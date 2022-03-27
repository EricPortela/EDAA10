import java.util.Random;

public class NumberGenerator {
	private static Random rand = new Random();  // slumptalsgenerator
	private int secretNbr;						// det hemliga talet
	private int min;							// minsta v�rde det hemliga talet kan ha
	private int max;							// st�rsta v�rde det hemliga talet kan ha

	/** Skapar ett objekt som kan generera med ett slumpm�ssigt valt hemligt 
		    heltal i intervallet [min, max]. */
	
	public NumberGenerator(int min, int max) {
		this.min = min;
		this.max = max;
		
		secretNbr = min + rand.nextInt(this.max-this.min+1);
	}

	/** Drar ett nytt hemligt tal. */
	public void drawNbr() {
		secretNbr = this.min + rand.nextInt(this.max-this.min+1);
	}

	/** Tar reda p� minsta m�jliga v�rde det hemliga talet kan ha. */
	public int getMin() {
		return this.min;
	}

	/** Tar reda p� st�rsta m�jliga v�rde det hemliga talet kan ha. */
	public int getMax() {
		return this.max;
	}

	/** Tar reda p� om det hemliga talet �r lika med guess. */
	public boolean isEqual(int guess) {
		if (guess == secretNbr) {
			return true;
		}
		return false;
	}

	/** Tar reda p� om det hemliga talet �r st�rre �n guess. */
	public boolean isBiggerThan(int guess) {
		if (secretNbr > guess) {
			return true;
		}
		return false;
	}
}

