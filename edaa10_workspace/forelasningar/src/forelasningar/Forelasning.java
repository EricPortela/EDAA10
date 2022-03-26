package forelasningar;
import java.util.*;

public class Forelasning {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double eps = scan.nextDouble();
		double term = 1 /(10 * Math.sqrt(10));
		double sum = 0;
		int k = 10;
		int sign = 1;
		
		while (Math.abs(term) > eps) {
			sum = sum + term;
			k = k + 1;
			sign = -sign;
			term = sign/ (k*Math.sqrt(k));
		}
		
		System.out.println("Summan blev" + sum);
		
		
	}

}
