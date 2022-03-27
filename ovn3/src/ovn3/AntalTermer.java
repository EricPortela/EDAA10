package ovn3;

public class AntalTermer {

	public static void main(String[] args) {
		//D3-2
		
		int summa = 0;
		int term = 1;
		int count = 0;
		
		while(summa < 100000) {
			summa += term;
			term += 2;
			count += 1;
		}
		
		System.out.print(count);

	}

}
