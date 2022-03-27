package ovn3;
import java.util.*;

public class IntilligandeHeltal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int nbr = 1, prevNbr = 0, count = 0, closeNbr = 0;
		
		System.out.print("Skriv in tal: ");
		
		while (nbr != 0) {
			if (count != 0) {
				prevNbr = nbr;
				nbr = scan.nextInt();
				
				if (nbr == prevNbr) {
					closeNbr += 1;
				}
				
			} else {
				nbr = scan.nextInt();
			}
			
			count += 1;
		}
		
		System.out.print("Antal gånger: ");
		System.out.print(closeNbr);
	}

}
