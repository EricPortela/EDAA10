package inl1;
import se.lth.cs.p.inl1.*; 
import se.lth.cs.p.inl1.nbr11.*;

public class Cryptographer {
	
	private Key key;

	/** Skapar ett objekt för chiffrering där nyckeln key används */
	public Cryptographer(Key key) {
		this.key = key;		
	}
	
	/** Chiffrerar texten text och returnerar chiffertexten */
	public String encrypt(String text) {
				
		//Current letter and letter-index in clearText
		char letter;
		int index = 0;
		
		//Chiffer variables
		int chifferKey = key.get5DigitNumber();
		String keyAsString = Integer.toString(chifferKey);
		
		int keyIndex = 0;
		String currentDigitKey;
		String chifferText = "";
		//String completeKeySequence = "";
				
		//Acquires the correct sequence of the chiffer key
		//The end result is the correct sequence as a String
		for (int x = 0; x < text.length(); x ++) {
			//Variables for clearText
			letter = text.charAt(x); //get char (letter) at index 
			index = letter - 'A'; //The index of the letter in the alphabet (A-Z)
			
			currentDigitKey = String.valueOf(keyAsString.charAt(keyIndex));
									
			int chiffer = Integer.valueOf(currentDigitKey);
			
			if (letter != ' ') { //If no blankspaces in clearText was found
				keyIndex ++; //Increase chifferIndex by one when it has been used
				
				//completeKeySequence += currentDigitKey;
				
				char alfa = key.getLetter(index, chiffer);
				chifferText += String.valueOf(alfa);
			} else {
				chifferText += " ";
			}
			
			if (keyIndex == 5) {
				keyIndex = 0; //Reset chifferIndex when all five digits have been used
			}	
		}
		//System.out.println(completeKeySequence);
		return chifferText;
	}
	
} 
