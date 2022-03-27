package ovn8;
import java.util.Random; 
import se.lth.cs.window.SimpleWindow; 


public class HemUppgifter8 {

	public static void main(String[] args) {
		
		//H8-2		
		
		Hemuppgift h = new Hemuppgift(7);
		
		h.addNbr(10, 2);
		
		h.removeNbr(1);
		
		System.out.println(h.allElementsGreaterThanZero());
		
		//H8-3
		
		Random r = new Random();
		
		char[] alphabet = new char[26];
		
		for (int i = 0; i<26; i++) {
			alphabet[i] = (char)('A'+i);
		}
		
		for (int i = 0; i<alphabet.length; i++) {
			int randomPosition = r.nextInt(26);
			char letter = alphabet[randomPosition];
			
			for (int k = randomPosition; k<alphabet.length-1; k++) {
				alphabet[k] = alphabet[k+1];
			}
			//alphabet[randomPosition];
			System.out.println("Varv"+i);
			System.out.println(letter);
			System.out.println(alphabet);
			System.out.println("\n");
			
		}
		
		System.out.println(alphabet);
		
		
	}

}
