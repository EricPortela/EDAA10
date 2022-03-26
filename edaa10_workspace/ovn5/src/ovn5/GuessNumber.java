package ovn5;
import java.util.*;
//import (default package) NumberGenerator;

public class GuessNumber {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int guess, count = 1;
		int min = scan.nextInt();
		int max = scan.nextInt();

		
		NumberGenerator nbrGen = new NumberGenerator(min, max);
		
		System.out.println("Skriv in ett tal mellan 1-99 ");
		guess = scan.nextInt();
		
		while (nbrGen.isEqual(guess) == false) {
			System.out.println("Fel tal!");
			
			if (nbrGen.isBiggerThan(guess)) {
				System.out.println("Det hemliga talet är större än " + guess);
			} else {
				System.out.println("Det hemliga talet är mindre än " + guess);
			}
			
			System.out.print("Gissa på nytt! ");
			guess = scan.nextInt();
			
			count += 1;
		}
		
		System.out.println("Korrekt! Talet är " + guess + "!");
		System.out.println("Antal försök: " + count);
		
		//scan.close();
	}

}
