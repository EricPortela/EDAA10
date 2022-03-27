import java.util.*;
import java.util.ArrayList;

public class TestComplex {

	public static void main(String[] args) {
		
		Random r = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i=0; i<10; i++) {
			numbers.add(1+r.nextInt(50));
		}
		
		//URVALSSORTERING MED ArrayList
		ArrayList<Integer> sorted1 = new ArrayList<Integer>(numbers);
		
		for (int i=0; i<sorted1.size()-1; i++) {
			int max = Integer.MIN_VALUE;
			int minIndex = -1;
			for (int k=i; k<sorted1.size(); k++) {
				if (sorted1.get(k) > max) {
					max = sorted1.get(k);
					minIndex = k;
				}
			}
			int temp = sorted1.get(i);
			sorted1.remove(minIndex);
			sorted1.add(minIndex,temp);
			sorted1.remove(i);
			sorted1.add(i, max);
		}
		
		for (int i=0; i<sorted1.size(); i++) {
			System.out.println(sorted1.get(i));
		}
		
		System.out.println("STOP");
		
		
		
		//INSÄTTNINGSSORTERING MED ArrayList
		ArrayList<Integer> sorted2 = new ArrayList<Integer>(numbers);

		for (int i=0; i<sorted2.size()-1; i++) {
			for (int k=i; k<sorted2.size(); k++) {
				int nbr = sorted2.get(i);
				int comparingNbr = sorted2.get(k);
				
				if (comparingNbr<nbr) {
//					sorted2.remove(i);
					sorted2.add(i,comparingNbr);
//					sorted2.remove(k);
					sorted2.add(k,nbr);
				}
			}
		}
		
		for (int i=0; i<sorted2.size(); i++) {
			System.out.println(sorted2.get(i));
		}
		
		System.out.println("STOP");
		
		
//		PhoneDirectory pb = new PhoneDirectory();
//		pb.addPerson("Sandra", "123");
//		pb.addPerson("Alice", "333");
//		pb.addPerson("Peter", "1234");
//		pb.addPerson("Anna", "6453");
//		ArrayList<Person> resultat = pb.getSortedPersonList();
//		
//		System.out.println("Ny lista: ");
//		
//		for (int i=0; i<resultat.size(); i++) {
//			System.out.println(resultat.get(i).getName());
//		}
		

		
//		Complex c1 = new Complex(0.4, 0.4);
//		Complex c2 = new Complex(0.2, 0.5);
//		
//		
//		System.out.println("Multiplication");
//		c1.mul(c1);
//		System.out.println(c1.getRe());
//		System.out.println(c1.getIm());
//		System.out.println();
//		
//		
//		System.out.println("Addition");
//		c1.add(c2);
//		System.out.println(c1.getRe());
//		System.out.println(c1.getIm());
//		System.out.println();
//		
//		
//		System.out.println("Absolute value (Pythagoras theorem)");
//		double abs = c1.getAbs2();
//		System.out.println(abs);
//		System.out.println();
//
//		
//		System.out.println("TEST RUN");
//		Complex c = new Complex(0.4, 0.4);
//		Complex z = new Complex(0, 0);
//		int k = 0;
//		
//		while (k <= 200 && z.getAbs2() <= 2) {
//			
//			System.out.println("ITERATION:" + " " + k);
//			System.out.println(z.getRe());
//			System.out.println(z.getIm());
//			System.out.println();
//					
//			z.mul(z);
//			z.add(c);
//			
//			
//			k++;
//		}
//		
		

		
		/*
		1 Välj ett komplext tal c
		2 k=0,z0=0+0i
		3 sålängek<MAX_ITERoch|zk|≤2: Öka k
		Beräkna zk
		4 Om k < MAX_ITER
		Följden är divergent (säkert)
		annars
		Följden är konvergent och c tillhör M (nästan säkert)
		*/
	}

}





