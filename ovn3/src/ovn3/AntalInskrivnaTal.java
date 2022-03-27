package ovn3;
import java.util.*;

public class AntalInskrivnaTal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int nbr = 1;
		int count = 0;
		
		System.out.print("Mata in en följd av positiva tal: ");
		
		nbr = scan.nextInt();
		
		while (nbr != 0) {
			count += 1;
			nbr = scan.nextInt();
		}
		
		System.out.print("Antal tal i talföljden: ");
		System.out.print(count);
		
	}

}
