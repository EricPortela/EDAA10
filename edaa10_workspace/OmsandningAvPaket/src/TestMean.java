import java.util.*;

public class TestMean {


	/* Denna metod simulerar sändningen av ett paket och håller på tills den 
	 * lyckas. När sändningen lyckas så returneras antal gånger man var tvungen
	 * att sända paketet innan man lyckades.
	 */
	
	public static int nbrSent(int size, double p){
		int counter = 0;
		do 
			counter++;
		while (!packetOK(size, p));
		return counter;
	}
	
	/* Denna metod avgör om en bit är korrekt eller inte. Med sannolikheten p är den inte
	 * korrekt och då returneras false annars returneras true. Så sannolikheten att false 
	 * returneras är alltså p. 
	 */
	
	public static boolean bitOK(double p) {
		Random rnd = new Random();
		if (rnd.nextDouble() < p) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/* Denna metod kollar om ett paket är korrekt eller inte. Det görs genom att kolla
	 * bit för bit och så snart en bit är fel (genom att bitOK() blir false) så reterneras 
	 * false. Om bitOK() blir true för alla bitar i paketet så returneras true.
	 */

	public static boolean packetOK(int size, double p){
		// Här nedan fattas kod (cirka fem rader), metoden ska naturligtvis inte bara returnera true. 
		for (int i=0; i<size; i++) {
			if (bitOK(p)==false) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		double p = 0.001;  //Sannolikheten att en bit är felaktig
		int size = 160 + 2000;   //Storleken på ett paket
		int counter = 0; // Denna räknare används för att räkna totala antalet paket som 
						 // skickas i detta simuleringsexperiment.
		int nbrExperiments = 10; // Antal paket som ska skicks i experimentet
		for (int i = 0; i < nbrExperiments; i++){  // Här sänds nbrExperiments paket
			counter = counter + nbrSent(size, p);  // counter används för att räkna totala antalet paket som skickas
		}
		System.out.println((1.0*counter/nbrExperiments)*size*nbrExperiments); //Medelvärdet av antal gånger ett paket måste skickas beräknas
	}
}
