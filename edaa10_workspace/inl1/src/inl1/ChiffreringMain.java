package inl1;
import se.lth.cs.p.inl1.*; 
import se.lth.cs.p.inl1.nbr11.*;

public class ChiffreringMain {

	public static void main(String[] args) {
		
		TextWindow tw = new TextWindow("Inlämningsuppgift 1 nr 11");
		
		TextView tv1 = new TextView("Klartext", 10, 100);
		TextView tv2 = new TextView("Min chiffertext", 10, 100);
		TextView tv3 = new TextView("Korrekt chiffertext", 10, 100);
		
		tw.addView(tv1);
		tw.addView(tv2);
		tw.addView(tv3);

		Key key = new Key();
		TestCase t = new TestCase();
		Cryptographer c = new Cryptographer(key);
		
		for (int i = 1; i < 6; i ++) {
			String clearText = t.getClearText(i);
			String cryptoText = t.getCryptoText(i);
			String myEncryption = c.encrypt(clearText);
			
			if (cryptoText.equals(myEncryption)) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
			}
			
			tv1.displayText(clearText);
			tv2.displayText(myEncryption);
			tv3.displayText(cryptoText);
			
			tw.waitForMouseClick();
		}
	}
}
