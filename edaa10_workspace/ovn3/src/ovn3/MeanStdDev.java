package ovn3;
import java.util.*;

public class MeanStdDev {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Skriv in antal tal: ");
		
		double nbr, total = 0, mean = 0, stdDev = 0, squaredNbrSum = 0; 
		int n = scan.nextInt();
		
		if (n > 5) {
			for (int k = 0; k < n; k ++) {
				nbr = scan.nextDouble();
				total += nbr;
				squaredNbrSum += Math.pow(nbr, 2);
			}
			
			mean = total / n;
			System.out.print("Medelvärdet är: ");
			System.out.print(mean);
			
			double meanSquared = Math.pow(mean, 2);
			stdDev = Math.sqrt((squaredNbrSum - n*meanSquared)/(n-1));
			System.out.print("\nStandardavvikelsen är: ");
			System.out.print(stdDev);
			
			
		} else {
			System.out.print("För få tal för standardavvikelse");
		}
	}

}
